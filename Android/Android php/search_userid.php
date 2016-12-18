<?php
	//เช็คว่าไอดีซ้ำไหม เก็บไว้ทำตอนที่เหลือเวลา
	require("dbconnect.php");
	$registerpass = true;
	
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
	if(strlen($CustomerUsername)<=0 || 
	strlen($CustomerPassword)<=0)
	{
		$registerpass = false;
	}

	if (!$registerpass)
	{
		$row['Status'] = "not pass";
		echo json_encode($row);

	}
?>