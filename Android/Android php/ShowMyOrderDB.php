<?php
	require_once("dbconnect.php");
	$CustomerID = 3;

	$sql = "SELECT * FROM Orders WHERE `CustomerID` = '$CustomerID'";
	$result = mysqli_query($link, $sql, MYSQLI_USE_RESULT);
	$row = mysqli_fetch_assoc($result);
	//echo $row['user_id']." : ";


	echo json_encode($row);
?>