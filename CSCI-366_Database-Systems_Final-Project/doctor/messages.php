<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <?php
      session_start();

      $_SESSION["doctor_id"] = 1;
    ?>
    <h1 style="font-size:30px;"><u>Messages</u></h1>
    <form method="post" action="/~monvande/final_project/doctor/inbox.php">
      <input type="submit" name="submit" value="Inbox">
    </form>
    <form method="post" action="/~monvande/final_project/doctor/sent.php">
      <input type="submit" name="submit" value="Sent">
    </form>
    <form method="post" action="/~monvande/final_project/doctor/send.php">
      <input type="submit" name="submit" value="Send New Message">
    </form>
    <br>
    <form method="post" action="/~monvande/final_project/doctor/home.php">
      <input type="submit" name="submit" value="Return to Home">
    </form>
    <?php echo $_SESSION["doctor_id"]; ?>
  </body>
</html>

