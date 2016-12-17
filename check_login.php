<?php
	session_start();
	mysql_connect("localhost","worawaluns_droid","Droid123");
	mysql_select_db("worawaluns_droid");

	echo $CustomerUsername = $_POST['CustomerUsername'];
	echo $CustomerPassword = $_POST['CustomerUsername'];

	$strSQL = "SELECT * FROM Customer WHERE CustomerUsername = '".mysql_real_escape_string($_POST['CustomerUsername'])."'
	and CustomerPassword = '".mysql_real_escape_string($_POST['CustomerPassword'])."'";


	$objQuery = mysql_query($strSQL);
	$objResult = mysql_fetch_array($objQuery);

	if(!$objResult)
	{
			header("location:error_page.php");
	}
	else
	{
			$_SESSION["CustomerID"] = $objResult["CustomerID"];
			$_SESSION["CustomerStatus"] = $objResult["CustomerStatus"];
			session_write_close();

			if($objResult['CustomerStatus']=='2')
			{
				header("location:index.php");
			}else{
			header("location:notification.php");
			}
	}
	mysql_close();
?>
