<?php
	require("dbconnect.php");
	$registerpass = true;
	
	if(!empty($_POST['CustomerEmail']))
	{
		$CustomerEmail = mysqli_escape_string($link,$_POST['CustomerEmail']);
	}else{
		$registerpass = false;
	}

	if(!empty($_POST['CustomerUsername']))
	{
		$CustomerUsername = mysqli_escape_string($link,$_POST['CustomerUsername']);
	}else{
		$registerpass = false;
	}

	if(!empty($_POST['CustomerPassword']))
	{
		$CustomerPassword = mysqli_escape_string($link,$_POST['CustomerPassword']);
	}else{
		$registerpass = false;
	}

	if(!empty($_POST['CustomerFullname']))
	{
		$CustomerFullname = mysqli_escape_string($link,$_POST['CustomerFullname']);
	}else{
		$registerpass = false;
	}
	if (!empty($_POST['CustomerTel'])) {
		$CustomerTel = mysqli_escape_string($link,$_POST['CustomerTel']);
	}else{
		$registerpass = false;
	}

	if(strlen($CustomerEmail)<=0 || 
	strlen($CustomerUsername)<=0 || 
	strlen($CustomerPassword)<=0 || 
	strlen($CustomerFullname)<=0 ||
	strlen($CustomerTel)<=0 )
	{	
		$registerpass = false;
	}

	if ($registerpass)
	{
		$sql = "INSERT INTO Customer (CustomerEmail,CustomerUsername,CustomerPassword,CustomerFullname,CustomerTel,CustomerStatus) 
 			VALUES('$CustomerEmail','$CustomerUsername','$CustomerPassword','$CustomerFullname','$CustomerTel','1')";

		$query = mysqli_query($link,$sql) or die("Query Error");
		include("search_userid.php");
	}
?>