<!DOCTYPE HTML>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <?php session_start(); ?>
    <h3>Message Successfully Sent!</h3>
    <form method="post" action="/~monvande/final_project/patient/send.php">
      <button type="submit">Send Another Message</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/sent.php">
      <button type="submit">View Sent Messages</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/messages.php">
      <button type="submit">Return to Messages</button>
    </form>
    <form method="post" action="/~monvande/final_project/patient/home.php">
      <button type="submit">Return to Home</button>
    </form>
    <?php echo "UserID:  ".$_SESSION["patient_id"]; ?>
  </body>
</html>

