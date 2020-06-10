<!DOCTYPE html>
<html>
  <head>
    <title>DB Healthcare</title>
  </head>
  <body>
    <?php
      session_unset();
      session_destroy();
    ?>
    <h1><u>Welcome to DB Healthcare Services!</u></h1>
    <p>We here at DB Healthcare Services are proud to serve you as one of the highest rated clinics in the city!  Please log in or sign up at the appropriate links below.<br></p>
    <br>
    <h3>Patient Login:</h3>
    <form method="post" action="/~monvande/final_project/patient/login.php">
      <input type="submit" name="submit" value="Login">
    </form>
    <form method="post" action="/~monvande/final_project/patient/signup.php">
      <input type="submit" name="submit" value="SignUp">
    </form>
  </body>
</html>
