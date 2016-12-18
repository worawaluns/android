<?php
	$host = "localhost";
	$username = "root";
	$password = "";
	$dbname = "fairy_bakery_shop";

	$link = mysqli_connect($host,$username,$password,$dbname) or die("Connect Error");
	mysqli_query($link,"SET NAMES UTF8");
?>