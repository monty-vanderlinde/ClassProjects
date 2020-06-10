<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <h1><u>Doctor Home Page</u></h1>

    <?php
      session_start();

      // Create connection to Oracle
      $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
      $stid = oci_parse($conn, "SELECT DoctorName FROM Doctor WHERE Doctor.DoctorID=".$_SESSION["doctor_id"]);
      $r = oci_execute($stid);

      while ($row = oci_fetch_array($stid,OCI_ASSOC)) {
        //iterate through each item in the row and echo it
        foreach ($row as $item){
          echo " Welcome $item !";
        }
        echo "<br>";
      }

      oci_free_statement($stid);
      oci_close($conn);
    ?>

    <form method="post" action="/~monvande/otherDB/DocPrescription.php">
      <input type="submit" name="submit" value="Prescriptions">
    </form>

    <form method="post" action="/~monvande/final_project/doctor/messages.php">
      <input type="submit" name="submit" value="Messages">
    </form>

    <form method="post" action="/~monvande/otherDB/DocPrescription.php">
      <input type="submit" name="submit" value="Appointments">
    </form>

    <form method="post" action="/~monvande/final_project/doctor/test.php">
      <input type="submit" name="submit" value="Test">
    </form>

    <?php
      // Create connection to Oracle
      $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
      $stid = oci_parse($conn, "SELECT Degree, City FROM Doctor WHERE Doctor.DoctorID=".$_SESSION["doctor_id"]);
      $r = oci_execute($stid);

      echo '<br/>';
      echo 'Your Information:';
      print '<table border="1">';
      while ($row = oci_fetch_array($stid, OCI_ASSOC)) {
        print '<tr>';
        foreach ($row as $item) {
          print '<td>'.($item !== null ? htmlentities($item, ENT_QUOTES) : '&nbsp').'</td>';
        }
        print '</tr>';
      }
      print '</table>';

      oci_free_statement($stid);
      oci_close($conn);
    ?>
    <form method="post" action="<?php
                                  session_unset();
                                  session_destroy();
                                  echo "/~monvande/final_project/home.html";
                                ?>">
      <input type="submit" name="submit" value="Logout">
    </form>
  </body>
</html> 

