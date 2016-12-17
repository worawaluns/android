<?php
	require './connect.php';

?>
<!DOCTYPE html>
<html>
<head>
	<title>Admin : User </title>
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
   <div class="header">รายการสมาชิก</div>

   <table cellspacing="0">
      <tr>
         <th>Picture</th>
         <th>Id Member</th>
         <th>Full Name</th>
         <th>Username</th>
         <th>Phone</th>
         <th>Status</th>
         <th>Manage</th>

      </tr>
			<?php
			$sql = "SELECT * FROM Customer";
			$query = mysqli_query($objConnect,$sql);


			while ($rows = mysqli_fetch_array($query)){

				$CustomerID = $rows[CustomerID];
				$CustomerEmail = $rows[CustomerEmail];
				$CustomerPic = $rows[CustomerPic];
				$CustomerUsername = $rows[CustomerUsername];
				$CustomerPassword = $rows[CustomerPassword];
				$CustomerFullname = $rows[CustomerFullname];
				$CustomerTel = $rows[CustomerTel];
				$CustomerStatus = $rows[CustomerStatus];
				?>
      <tr>
         <td class="image"><img src="<?php echo $CustomerPic;?>" alt="" /></td>
         <td><?php echo $CustomerID; ?></td>
         <td><?php echo $CustomerFullname; ?></td>
         <td><?php echo $CustomerUsername; ?></td>
         <td><?php echo $CustomerTel; ?></td>
         <td><?php if($CustomerStatus==3){echo "Baned";}
				 if($CustomerStatus==1){echo "User";}
				 if($CustomerStatus==2){echo "Admin";} ?></td>
         <td class="color"><a href="edit_user_db.php?id=<?php echo $CustomerID;?>"><i class="fa fa-pencil"></i></a> &nbsp;&nbsp;<a href="member_ban_db.php?id=<?php echo $CustomerID;?>"><i class="fa fa-ban"></i> Ban User</a><?php if($CustomerStatus==3){ ?><a href="member_unban_db.php?id=<?php echo $CustomerID;?>"> <strong>[Un-Baned]</strong> </a> <?php }?></td>
      </tr>
			<?php } ?>
   </table>
</div>



</div><!-- end content -->


<script src="js/index.js"></script>
</body>
</html>
