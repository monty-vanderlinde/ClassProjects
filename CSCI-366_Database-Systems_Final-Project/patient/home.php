<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <h1><u>Patient Home Page</u></h1>

    <?php
      session_start();
//      echo $_POST["username"];

      // Create connection to Oracle
      $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
      $stid = oci_parse($conn, "SELECT PatientName FROM Patient WHERE Patient.PatientID=".$_SESSION["patient_id"]);
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

    <form method="post" action="/~monvande/final_project/patient/messages.php">
      <input type="submit" name="submit" value="Messages">
    </form>

    <?php
      // Create connection to Oracle
      $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
      $stid = oci_parse($conn, "SELECT Address, City FROM Patient WHERE Patient.PatientID=".$_SESSION["patient_id"]);
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
    <form method="post" action="/~monvande/final_project/home.php">
      <input type="submit" name="submit" value="Logout">
    </form>
    <?php echo "UserID:  ".$_SESSION["patient_id"]; ?>
  </body>
</html> 

