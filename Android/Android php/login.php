<?php
	require_once("dbconnect.php");

	if(!empty($_POST['login_username']))
	{
		$username = mysqli_escape_string($link,$_POST['login_username']);
	}

	if(!empty($_POST['login_password']))
	{
		$password = mysqli_escape_string($link,$_POST['login_password']);
	}

	$sql = "SELECT `CustomerID`, `CustomerEmail`, `CustomerUsername`, `CustomerFullname` , `CustomerTel`, `CustomerStatus` FROM Customer WHERE `CustomerUsername` = '$username' AND `CustomerPassword` = '$password'";
	$result = mysqli_query($link, $sql, MYSQLI_USE_RESULT);
	$row = mysqli_fetch_assoc($result);
	//echo $row['user_id']." : ";


	echo json_encode($row);
?>