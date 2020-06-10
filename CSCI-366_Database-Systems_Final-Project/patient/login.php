<!DOCTYPE HTML>
<html>
  <head>
    <title>DB Healthcare</title>
    <style>.error {color: #FF0000;}</style>
  </head>
  <body>

    <?php
      //starts a lasting session
      session_start();

      $_SESSION["patient_id"] = 0;

      $username = "";
      $username_error = "";
      $password = "";
      $password_error = "";

      //printed out if login is unsuccessful
      $login_error = "";

      if ($_SERVER["REQUEST_METHOD"] == "POST") {
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
      if($username_error == "" && $password_error == ""){
        $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
        $stid = oci_parse($conn, "SELECT PatientID FROM Patient WHERE Patient.PatientUsername = '$username' AND Patient.PatientPassword = '$password'");
        $r = oci_execute($stid);

        //should only be able to get one row
        $row = oci_fetch_array($stid,OCI_ASSOC);

        if($row != null){
          foreach ($row as $item)
          {
            $_SESSION["patient_id"] = $item;
          }
        }

        oci_free_statement($stid);
        oci_close($conn);
      }

      function input_check($text) {
        return trim(stripslashes(htmlspecialchars($text)));
      }

      if($_SESSION["patient_id"] != 0) {
        header("Location:http://students.cs.ndsu.nodak.edu/~monvande/final_project/patient/home.php");
        exit();
      }
    ?>

    <h3>Please enter your login credentials:</h3>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
      <div class="container">
        <label for="username">Username</label>
        <input type="text" placeholder="Enter Username" name="username" required>
        <span class="error">* <?php echo $username_error;?></span>
        <br>
        <label for="password">Password</label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <span class="error">* <?php echo $password_error;?></span>
        <br>
        <span class="error"><?php echo $login_error;?></span>
        <br>
        <button type="submit">Login</button>
        <br><br>
      </div>
    </form>
    <form method="post" action="/~monvande/final_project/home.php">
      <input type="submit" name="submit" value="Back to Home">
    </form>
  </body>
</html>

