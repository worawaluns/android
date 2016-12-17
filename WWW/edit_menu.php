<?php
	require './connect.php';

	$MenuID = $_GET['id'];



?>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<link rel="stylesheet" type="text/css" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="js/menu.css">
	<link rel="stylesheet" href="js/upload1.css">
	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>


</head>
<body>
	<nav id="slide-menu">
	<ul>
		<li class="timeline"><a href="index.php">Order</a></li>
		<li class="events"><a href="admin_menu.php">Menu</a></li>
		<li class="calendar"><a href="admin_insert.php">Insert menu</a></li>
		<li class="sep settings"><a href="admin_member.php">Member</a></li>
		<li class="logout"><a href="#">Log out</a></li>
	</ul>
</nav>
<!-- Content panel -->
<div id="content">

	<?php

	$sql = "SELECT * FROM Menu
					WHERE MenuID = {$MenuID}";
	$query = mysqli_query($objConnect,$sql);
	while ($rows = mysqli_fetch_array($query)){
		$MenuID = $rows[MenuID];
		$MenuName = $rows[MenuName];
		$MenuPrice = $rows[MenuPrice];
		$MenuDescription = $rows[MenuDescription];
		$MenuCal = $rows[MenuCal];
}

	 ?>
	 <form action="edit_menu_db.php" method="post" enctype="multipart/form-data">
	<div class="menu-trigger"></div>
	<div class="file-upload">
  <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger( 'click' )">Add Image</button>

  <div class="image-upload-wrap">
    <input class="file-upload-input" type='file' name="files" onchange="readURL(this);" accept="image/*" />
    <div class="drag-text">
      <h3>Drag and drop a file or select add Image</h3>
    </div>
  </div>

  <div class="file-upload-content">
    <img class="file-upload-image" src="#" alt="your image" />
    <div class="image-title-wrap">
      <button type="button" onclick="removeUpload()" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
    </div>
  </div>
</div><!-- end upload -->
<div id="wrap-upload">
						<input type="hidden" name="MenuID" value="<?php echo $MenuID; ?>">
  					<input type="text" name="Name" value="<?php echo $MenuName;?>" placeholder='Name' required='' type='text'>
  					<input type="text" name="Calories" value="<?php echo $MenuCal;?>" placeholder='Calories' required='' type='text'>
  					<input type="text" name="Price" value="<?php echo $MenuPrice;?>" placeholder='Price' required='' type='text'>
  					<input type="text" name="Detail" value="<?php echo $MenuDescription;?>" placeholder='Detail' required='' type='text'>
  					<br>
  					<br>
  					<center><input type="submit" id="blue-btn" value="Add Product">

				</form>
</div><!-- end wrap-upload -->
</div>



<script src="js/index.js"></script>
<script src="js/upload.js"></script>
</body>
</html>
