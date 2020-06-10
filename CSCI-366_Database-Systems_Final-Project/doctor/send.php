<!DOCTYPE HTML>
<html>
  <head>
    <title>DB Healthcare</title>
    <style>.error {color: #FF0000;}</style>
  </head>
  <body>

    <?php
      session_start();

      date_default_timezone_set("America/Chicago");

      $message = "";
      $message_error = "";

      if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $message = input_check($_POST["message"]);
        if($message == "" || !preg_match("/^[a-z0-9A-Z . ! ? ' : , ]*$/",$message)){
          $message_error = "Can only contain letters, numbers, and basic sentance punctuation (. ! ? ' : ,)!";
        }
      }

      //check message is clear of errors
      if($_SERVER["REQUEST_METHOD"] == "POST" && $message_error == ""){
        $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
        $stid = oci_parse($conn, "INSERT INTO SentMessage VALUES(".rand(1,getrandmax()).", ".$_SESSION["doctor_id"].", NULL, TODATE('".date("d-m-Y h:ia")."','DD-MM-YY HH12:MIAM'), '".$message."', SELECT PatientName FROM Patient WHERE PatientName)");
        $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
        $stid = oci_parse($conn, "INSERT INTO SentMessage VALUES(".rand(1,getrandmax()).", NULL, "..", TODATE('".date("d-m-Y h:ia")."','DD-MM-YY HH12:MIAM'), '".$message."', (SELECT DoctorName FROM Doctor WHERE Doctor.DoctorID = ".$_SESSION["doctor_id"]."))");
        $r = oci_execute($stid, OCI_COMMIT_ON_SUCCESS);
        $r = oci_commit($conn);
        oci_free_statement($stid);
        oci_close($conn);
        header("Location:http://students.cs.ndsu.nodak.edu/~monvande/final_project/doctor/message_sent.html");
        exit();
      }

      function input_check($text) {
        return trim(stripslashes(htmlspecialchars($text)));
      }
    ?>

    <h3>Please enter your message below:</h3>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
      <div class="container">
        <textarea rows = "8" cols = "32" name = "message" placeholder="Enter Message" maxlength=256 required></textarea>
        <span class="error">* <?php echo $message_error;?></span>
        <br>
        <button type="submit">Send</button>
        <br><br>
      </div>
    </form>
    <form method="post" action="<?php echo "/~monvande/final_project/home.html";?>">
      <input type="submit" name="submit" value="Back to Home">
    </form>
    <?php //echo $_SESSION["doctor_id"]; ?>
  </body>
</html>

