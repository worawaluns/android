<?php
	require './connect.php';

?>
<!DOCTYPE html>
<html>
<head>
	<title>Menu</title>
	<meta charset="UTF-8">
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
   <div class="header">รายการสินค้า</div>

   <table cellspacing="0">
      <tr>
         <th>Picture</th>
         <th>Id Product</th>
         <th>Name</th>
         <th>Calories</th>
         <th>Price</th>
         <th width="230">Detail</th>
         <th>Manage</th>
      </tr>
			<?php
			$sql = "SELECT * FROM Menu
							ORDER BY MenuCal ASC";
			$query = mysqli_query($objConnect,$sql);
			while ($rows = mysqli_fetch_array($query)){
				$MenuID = $rows[MenuID];
				$MenuName = $rows[MenuName];
				$MenuPrice = $rows[MenuPrice];
				$MenuDescription = $rows[MenuDescription];
				$MenuCal = $rows[MenuCal];


			?>
      <tr>
         <td><img src="<?php echo $rows[MenuPic]; ?>" alt="" /></td>
         <td><?php echo $MenuID; ?></td>
         <td><?php echo $MenuName; ?></td>
         <td><?php echo $MenuCal; ?></td>
         <td><?php echo $MenuPrice; ?></td>
         <td><?php echo $MenuDescription; ?></td>
         <td class="color"><a href="edit_menu.php?id=<?php echo $MenuID;?>"><i class="fa fa-pencil"></i></a> &nbsp;&nbsp;<a href="delete_menu_db.php?id=<?php echo $MenuID;?>"><i class="fa fa-trash"></i></a></td>
      </tr>
      <?php } ?>
   </table>
</div>



</div><!-- end content -->


<script src="js/index.js"></script>
</body>
</html>
