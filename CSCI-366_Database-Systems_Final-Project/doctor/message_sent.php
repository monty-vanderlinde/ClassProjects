<!DOCTYPE HTML>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <?php
      session_start();
    ?>
    <h3>Message Successfully Sent!</h3>
    <form method="post" action="/~monvande/final_project/doctor/home.php">
      <button type="submit">Return Home</button>
    </form>
    <form method="post" action="/~monvande/final_project/doctor/send.php">
      <button type="submit">Send Another Message</button>
    </form>
  </body>
</html>

