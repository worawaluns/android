<?php
	require './connect.php';

	if($_SESSION["CustomerStatus"]=="1"){
		header('location:admin.php');
	}

?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<link rel="stylesheet" type="text/css" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="js/menu.css">
	<link rel="stylesheet" href="js/table.css">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


</head>
<body>

	<nav id="slide-menu">
	<ul>
		<li class="timeline"><a href="index.php">Order</a></li>
		<li class="events"><a href="admin_menu.php">Menu</a></li>
		<li class="calendar"><a href="admin_insert.php">Insert menu</a></li>
		<li class="sep settings"><a href="admin_member.php">Member</a></li>
		<li class="logout"><a href="logout.php">Log out</a></li>
	</ul>
</nav>
<!-- Content panel -->

<div id="content">

	<div class="menu-trigger"></div>

<div class="table-users">
   <div class="header">รายการสั่งซื้อสินค้า</div>

   <table cellspacing="0">
      <tr>
				<th>Date</th>
				<th>OrdersID</th>
         <th>CustomerID</th>
         <th>OrdersTotal</th>
         <!-- <th>MenuName</th> -->
         <!-- <th>OdetailAmount</th> -->
         <th>OrdersStatus</th>
      </tr>
			<?php
			$sql = "SELECT 	Orders.OrdersDate,
											Orders.OrdersID,
											Orders.CustomerID,
											Orders.OrdersTotal,

											Orders.OrdersStatus
							FROM Orders";

			$query = mysqli_query($objConnect,$sql);


			while ($rows = mysqli_fetch_array($query)){
				$OrdersDate = $rows[OrdersDate];
				$OrdersID = $rows[OrdersID];
				$CustomerID = $rows[CustomerID];
				$OrdersTotal = $rows[OrdersTotal];
				// $OdetailAmount = $rows[OdetailAmount];
				$OrdersStatus = $rows[OrdersStatus];
				// $MenuName = $rows[MenuName];


			?>
			<tr>
				 <td style="background-color: #ffe998;"><?php echo $OrdersDate;?></td>
         <td style="background-color: #ffe998;"><?php echo $OrdersID;?></td>
         <td style="background-color: #ffe998;"><?php echo $CustomerID;?></td>
				 <td style="background-color: #ffe998;"><?php echo $OrdersTotal;?></td>
				 <td style="background-color: #ffe998;"><?php if($OrdersStatus=="1"){ echo "Success";} else if($OrdersStatus="Processing"){echo "Processing";?><a href="update_order_db.php?id=<?php echo $OrdersID; ?>"><strong> | <i class="fa fa-check"></i></strong></a><?php }?></td>

      </tr>
			<tr><?php
					$sql2 = " SELECT 	OrdersDetail.MenuName,
														OrdersDetail.OdetailAmount
										FROM 		OrdersDetail
										WHERE 	OrdersDetail.OrdersID = $OrdersID";
					$query2 = mysqli_query($objConnect,$sql2);
					$menu_num = 1;
					while ($rows2 = mysqli_fetch_array($query2)){
						$OdetailAmount = $rows2[OdetailAmount];
						$MenuName 		= $rows2[MenuName];
				?>
							<tr>
								<td></td>
								<td></td>
								<td><? echo "#" . $menu_num;  $menu_num++;?></td>
								<td>Menu: <? echo $MenuName; ?></td>
								<td>Amount: <? echo $OdetailAmount; ?></td>
							</tr>

					<? } ?>
			</tr>
			<tr><td></td><td></td><td></td><td></td><td></td></tr>
      <?php } ?>

   </table>
</div>



</div><!-- end content -->


<script src="js/index.js"></script>
</body>
</html>
