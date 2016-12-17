<?php
 	$connect="localhost";
 	$db_user="worawaluns_droid";
 	$db_password="Droid123";
 	$db_select="worawaluns_droid";

 	$objConnect= mysqli_connect($connect,$db_user,$db_password,$db_select);
 	if(!$objConnect){
 		echo "db error <br>";
 	}

 ?>
