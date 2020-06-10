<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <?php session_start(); ?>
    <h1 style="font-size:30px;"><u>Messages</u></h1>
    <form method="post" action="/~monvande/final_project/patient/inbox.php">
      <button type="submit">Inbox</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/sent.php">
      <button type="submit">Sent</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/send.php">
      <button type="submit">Send New Message</button>
    </form>
    <br>
    <form method="post" action="/~monvande/final_project/patient/home.php">
      <button type="submit">Return to Home</button>
    </form>
    <?php echo "UserID:  ".$_SESSION["patient_id"]; ?>
  </body>
</html>

