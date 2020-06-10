<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
    <?php session_start(); ?>
    <h1 style="font-size:30px;"><u>Received Messages</u></h1>

    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    <?php
      $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
      $stid = oci_parse($conn, "SELECT ReceivedMessageID, SenderName, TO_CHAR(ReceivedDateTime,'DD-MON-YY HH12:MIAM') FROM ReceivedMessage WHERE ReceivedMessage.PatientID = ".$_SESSION["patient_id"]);
      $r = oci_execute($stid);

      $ticker = 0;
      $counter = 0;

      while ($row = oci_fetch_array($stid,OCI_ASSOC)) {
        foreach ($row as $item)
        {
          if($ticker == 0){
            echo "<input id=\"".++$counter."\" type=\"submit\" name=\"submit\" value=\"".$item."\">";
            $ticker++;
          }
          else{
            if($ticker == 1){
              echo "Message sent by $item ";
              $ticker++;
            }
            else{
              echo "on $item.";
              $ticker = 0;
            }
          }
        }
        echo "<br>";
      }

      oci_free_statement($stid);
      oci_close($conn);
    ?>
    </form>

    <br>
    <form method="post" action="/~monvande/final_project/patient/messages.php">
      <button type="submit">Return to Messages</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/home.php">
      <button type="submit">Return to Home</button>
    </form>
    <br>
    <?php
      $messageID = 0;

      if ($_SERVER["REQUEST_METHOD"] == "POST"){
        ob_start();
        $temp = (int)$_POST["submit"];
        var_dump($temp);
        $messageID = $temp;
        ob_end_clean();
      }

      echo "Message:<br>";

      if($messageID != 0){
        $conn = oci_connect('monvande', 'Islandk14', '(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(Host=db2.ndsu.edu)(Port=1521)))(CONNECT_DATA=(SID=cs)))');
        $stid = oci_parse($conn, "SELECT MessageText FROM ReceivedMessage WHERE ReceivedMessage.ReceivedMessageID = ".$messageID);
        $r = oci_execute($stid);

        while ($row = oci_fetch_array($stid,OCI_ASSOC)){
          foreach ($row as $item){
            echo $item;
          }
        }
      }
      echo "<br><br>";
      echo "UserID:  ".$_SESSION["patient_id"];
    ?>
  </body>
</html>

