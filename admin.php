<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<link rel="stylesheet" type="text/css" href="fonts/awe/font-awesome.min.css">
	<meta charset="utf-8">
</head>
<body>
	<div id="wrapper">
		<div id="log-in-box"><br>
		<center><div id="logo-login"><img src="img/logo.png" width="171" height="155"></div></center>

				<form action="check_login.php" method="POST">
  					<input type="text" placeholder='Username' required='' type='text' name="CustomerUsername" pattern="^[a-zA-Z0-9-_\.]{1,20}$">
  					<input type="password" placeholder='Password' required='' type='text' name="CustomerPassword" pattern="^[a-zA-Z0-9-_\.]{1,11}$">
  					<br>
  					<br>
  					<center><input type="submit" id="blue-btn" value="Sign in"></center>

				</form>
			</div>

	</div>

</body>
</html>
