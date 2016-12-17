<?php
	require './connect.php';

	$MenuID = $_GET['id'];


	$sql = "DELETE FROM Menu
					WHERE MenuID = {$MenuID};";
	$query = mysqli_query($objConnect,$sql);

	if(!$query){
		echo "Error";
	}else{
		header('location:admin_menu.php');
	}

?>
