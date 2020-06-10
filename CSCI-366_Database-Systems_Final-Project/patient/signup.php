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
      $address = "";
      $address_error = "";
      $city = "";
      $city_error = "";
      $username = "";
      $username_error = "";
      $password = "";
      $password_error = "";
      $doctor = "";

      //printed out if signup is unsuccessful
      $signup_error = "";

      if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $name = input_check($_POST["name"]);
        if($name == "" || !preg_match("/^[a-z0-9A-Z ]*$/",$name)){
          $name_error = "Cannot contain special characters!";
        }
        $address = input_check($_POST["address"]);
        if($address == "" || !preg_match("/^[a-z0-9A-Z\. ]*$/",$address)){
          $address_error = "Cannot contain special characters (except . ! ?)!";
        }
        $city = input_check($_POST["city"]);
        if($city == "" || !preg_match("/^[a-z0-9A-Z\, ]*$/",$city)){
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
        $doctor = input_check($_POST["doctor"]);
      }

      if($username_error == "" && $password_error == "" && $_SERVER["REQUEST_METHOD"] == "POST"){
        $login_error = "Login Failed!  Password and/or username are/is incorrect!";
      }

      //check username and password are clear of errors
      if($_SERVER["REQUEST_METHOD"] == "POST" && $name_error == "" && $address_error == "" && $city_error == "" && $username_error == "" && $password_error == ""){
        $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
        $stid = oci_parse($conn, "SELECT PatientID FROM Patient WHERE Patient.PatientUsername = '$username'");
        $r = oci_execute($stid);

        //if the username already exists
        if(oci_fetch_array($stid,OCI_ASSOC)){
          $signup_error = "This username is already taken.  Please try another name.";
          oci_free_statement($stid);
          oci_close($conn);
        } else {
          $rand = rand(1,getrandmax());
          $stid = oci_parse($conn, "INSERT INTO Patient VALUES(".$rand.", (SELECT DoctorID FROM Doctor WHERE Doctor.DoctorName = '".$doctor."'), '".$name."', '".$address."', '".$city."', '".$username."', '".$password."')");
          $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
          $stid = oci_parse($conn, "INSERT INTO ReceivedMessage VALUES(".rand(1,getrandmax()).", NULL, ".$rand.", TO_DATE('".date("d-m-Y h:ia")."','DD-MM-YYYY HH12:MIAM'), 'Welcome to DB Heathcare Services!  We are glad to have you as a customer.  Please message us if you have any questions.', '".$doctor."')");
          $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
          $stid = oci_parse($conn, "INSERT INTO SentMessage VALUES(".rand(1,getrandmax()).", (SELECT DoctorID FROM Doctor WHERE Doctor.DoctorName = '".$doctor."'), NULL, TO_DATE('".date("d-m-Y h:ia")."','DD-MM-YYYY HH12:MIAM'), 'Welcome to DB Heathcare Services!  We are glad to have you as a customer.  Please message us if you have any questions.', '".$name."')");
          $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
          $r = oci_commit($conn);
          oci_free_statement($stid);
          oci_close($conn);
          header("Location:http://students.cs.ndsu.nodak.edu/~monvande/final_project/patient/signup_success.php");
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
        <label for="address">Address</label>
        <input type="text" placeholder="Enter Address" name="address" required>
        <span class="error">* <?php echo $address_error;?></span>
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
        <label for="doctor">Pick a Doctor:</label>
        <?php
          $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
          $stid = oci_parse($conn, "SELECT DoctorName FROM Doctor");
          $r = oci_execute($stid);

          while ($row = oci_fetch_array($stid,OCI_ASSOC)) {
            foreach ($row as $item)
            {
              echo "<br><input type=\"radio\" name=\"doctor\" checked value=\"".$item."\">".$item;
            }
          }

          oci_free_statement($stid);
          oci_close($conn);
        ?>
        <br>
        <span class="error"><?php echo $signup_error;?></span>
        <br>
        <button type="submit">SignUp</button>
        <br><br>
      </div>
    </form>
    <form method="post" action="/~monvande/final_project/home.php">
      <input type="submit" name="submit" value="Back to Home">
    </form>
  </body>
</html>

