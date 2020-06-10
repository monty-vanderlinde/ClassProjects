<!DOCTYPE HTML>
<html>
  <head>
    <title>DB Healthcare</title>
    <style>.error {color: #FF0000;}</style>
  </head>
  <body>

    <?php
      session_start();

      $name = "";
      $name_error = "";
      $degree = "";
      $degree_error = "";
      $other_credentials = "";
      $other_credentials_error = "";
      $city = "";
      $city_error = "";
      $username = "";
      $username_error = "";
      $password = "";
      $password_error = "";

      //printed out if signup is unsuccessful
      $signup_error = "";

      if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $name = input_check($_POST["name"]);
        if($name == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$name)){
          $name_error = "Cannot contain special characters!";
        }
        $degree = input_check($_POST["degree"]);
        if($degree == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$degree)){
          $degree_error = "Cannot contain special characters!";
        }
        $other_credentials = input_check($_POST["other_credentials"]);
        if($other_credentials == "" || !preg_match("/^[a-z0-9A-Z\.\!\? ]*$/",$other_credentials)){
          $other_credentials_error = "Cannot contain special characters (except . ! ?)!";
        }
        $city = input_check($_POST["city"]);
        if($city == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$city)){
          $city_error = "Cannot contain special characters!";
        }
        $username = input_check($_POST["username"]);
        if($username == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$username)){
          $username_error = "Cannot contain special characters!";
        }
        $password = input_check($_POST["password"]);
        if($password == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$password)){
          $password_error = "Cannot contain special characters!";
        }
      }

      if($username_error == "" && $password_error == "" && $_SERVER["REQUEST_METHOD"] == "POST"){
        $login_error = "Login Failed!  Password and/or username are/is incorrect!";
      }

      //check username and password are clear of errors
      if($_SERVER["REQUEST_METHOD"] == "POST" && $name_error == "" && $degree_error == "" && $other_credentials_error == "" && $city_error == "" && $username_error == "" && $password_error == ""){
        $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
        $stid = oci_parse($conn, "SELECT DoctorID FROM Doctor WHERE Doctor.DoctorUsername = '$username'");
        $r = oci_execute($stid);

        //if the username already exists
        if(oci_fetch_array($stid,OCI_ASSOC)){
          $signup_error = "This username is already taken.  Please try another name.";
          oci_free_statement($stid);
          oci_close($conn);
        } else {
          $stid = oci_parse($conn, "INSERT INTO Doctor VALUES(".rand(1,getrandmax()).", '".$name."', '".$degree."', '".$other_credentials."', '".$city."', '".$username."', '".$password."')");
          $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
          $r = oci_commit($conn);
          oci_free_statement($stid);
          oci_close($conn);
          header("Location:http://students.cs.ndsu.nodak.edu/~monvande/final_project/doctor/signup_success.html");
          exit();
        }
      }

      function input_check($text) {
        return trim(stripslashes(htmlspecialchars($text)));
      }
    ?>

    <h3>Please enter your login credentials:</h3>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
      <div class="container">
        <label for="name">Name</label>
        <input type="text" placeholder="Enter Name" name="name" required>
        <span class="error">* <?php echo $name_error;?></span>
        <br>
        <label for="degree">Degree</label>
        <input type="text" placeholder="Enter Degree" name="degree" required>
        <span class="error">* <?php echo $degree_error;?></span>
        <br>
        <label for="city">City</label>
        <input type="text" placeholder="Enter City" name="city" required>
        <span class="error">* <?php echo $city_error;?></span>
        <br>
        <label for="username">Username</label>
        <input type="text" placeholder="Enter Username" name="username" required>
        <span class="error">* <?php echo $username_error;?></span>
        <br>
        <label for="password">Password</label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <span class="error">* <?php echo $password_error;?></span>
        <br>
        <label for="other_credentials">Other Credentials</label>
        <br>
        <textarea rows = "8" cols = "32" name = "other_credentials" placeholder="Enter Other Credentials" maxlength=256 required></textarea>
        <span class="error">* <?php echo $other_credentials_error;?></span>
        <br>
        <span class="error"><?php echo $signup_error;?></span>
        <br>
        <button type="submit">SignUp</button>
        <br><br>
      </div>
    </form>
    <form method="post" action="<?php echo "/~monvande/final_project/home.html";?>">
      <input type="submit" name="submit" value="Back to Home">
    </form>
  </body>
</html>

