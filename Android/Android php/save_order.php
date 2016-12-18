<?php
	require_once("dbconnect.php");
	$insertPass = true;

	// id สินค้าแต่ละเมนู
	if(!empty($_POST['ids']))
	{
		$ids = $_POST['ids'];
	  	$ids = explode(',', $ids);
	}else{
		$insertPass = false;
	  }

	 // ชื่อสินค้าแต่ละเมนู
	if(!empty($_POST['names']))
	{
		$names = $_POST['names'];
	  	$names = explode(',', $names);
	}else{
		$insertPass = false;
	}

	 // จำนวนที่สั่งซื้อแต่ละเมนู
	if(!empty($_POST['amounts']))
	{
		$amounts = $_POST['amounts'];
	  	$amountsMenuPerMenu = explode(',', $amounts);
	}else{
		$insertPass = false;
	}

	// จำนวนที่สั่งซื้อแต่ละเมนู
 if(!empty($_POST['prices']))
 {
	 $prices = $_POST['prices'];
		 $prices = explode(',', $prices);
 }else{
	 $insertPass = false;
 }


	 // ราคารวมสินค้าแต่ละเมนู
	if(!empty($_POST['totals']))
	{
		$totals = $_POST['totals'];
	  	$amountsPricePerMenu = explode(',', $totals);
	}else{
		$insertPass = false;
	}

	 // user id
	if(!empty($_POST['customerId']))
	{
		$customerId = $_POST['customerId'];

	}else{
		$insertPass = false;
	}

	 // if(!empty($_POST['customerId']))
	 // {
	 //  $customerId = mysqli_escape_string($link,$_POST['customerId']);
	 // }else{
	 // 	$insertPass = false;
	 // }

	 // ราคารวมสินค้าทั้งหมด
	if(!empty($_POST['orderTotal']))
	{
		$orderTotal = $_POST['orderTotal'];
	}else{
		$insertPass = false;
	}

	 if ($insertPass) {
	 	//เอา order ลง DB
	 	$sqlInsertOrder = "INSERT INTO Orders (OrdersTotal,CustomerID,OrdersStatus) VALUES('$orderTotal','$customerId','Processing')";
		$querysqlInsertOrder = mysqli_query($link,$sqlInsertOrder) or die("Query Error");

 		$last_id = mysqli_insert_id($link);
		$OrdersIDDB = $last_id;
		//หา order ID จาก DB
		// $sqlFindOrderID = "SELECT `OrdersID` FROM Orders WHERE `OrdersTotal` = '$orderTotal' AND `CustomerID` = '$customerId' AND `OrdersStatus` = 'Processing' ORDER BY OrdersID DESC";
		// $resultFindOrderID = mysqli_query($link, $sqlFindOrderID);
		//$row = mysqli_fetch_assoc($resultFindOrderID);
		
		//mysqli_close($link);
		echo $OrdersIDDB;


	 	echo "array iCount : ";
	 	print_r($ids);
		//s$iCount = sizeof($ids);
		for ($i = 0; $i<count($ids); $i++) {


			// //เอา OrderDetail ใส่ลง DB
			$name = $names[$i];
			$amount = $amountsMenuPerMenu[$i];
			$totalPrice= $amountsPricePerMenu[$i];
			$pricemenu = $prices[$i];

			// echo $name."|||";
			// echo $amount."|||";
			// echo $totalPrice."|||";
			// echo $pricemenu."|||||||";

			$sqlInsertOrderDetail = "INSERT INTO `fairy_bakery_shop`.`OrdersDetail` (`MenuName`, `OdetailAmount`, `OdetailPrice`, `OdetailTotal`, `OrdersID`) VALUES ('$name', '$amount', '$pricemenu', '$totalPrice', '$OrdersIDDB')";

			$_querysqlInsertOrder = mysqli_query($link,$sqlInsertOrderDetail);

			echo("Error description: " . mysqli_error($link));

	}

	 }





     // foreach ($_SESSION['cart'] as $product_id => $value) {


	    // 	foreach ($value as $key => $detail) {
	    //         if ($key=='amount') {
	    //         	 //echo " &nbsp;&nbsp;&nbsp;&nbsp&nbsp;";
	    //         	$amount = $detail;
	    //         }
	    //         if ($key=='amount') {
	    //         	//echo " ea"."<br />";
	    //         }
	    //         if ($key=='img') {
	    //         	$img=$detail;
	    //         }

	   	// 	}


		   //  $sql2 ="SELECT * FROM product WHERE product_id ='$product_id' ";
		   //  $query2 = mysqli_query($objConnect,$sql2);

		   //  while($row2 = mysqli_fetch_array($query2)){
		   //  	$id_member = $_SESSION['member_id'];
		   //  	$p_id = $row2['product_id'];
		   //  	$name =  $row2['Name'];
		   //  	$price = $row2['Price'];
		   //  	$amount = $amount;
		   //  	$totalPrice = $row2['Price']*$amount;
		   //  	$totalP = $totalPrice;
		   //  	$image = $img;
		   //  	$totalPriceAll += $totalPrice;
		  	// 	$sql ="INSERT INTO orders_Detail (product_id,amount,price,image,total,member_id) VALUES ('{$p_id}','{$amount}','{$price}','{$image}','{$totalP}','{$id_member}')";
		 		// $query = mysqli_query($objConnect,$sql);
    	// 	}

    	// }else{};

?>
