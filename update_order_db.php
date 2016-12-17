<?php
  require './connect.php';
  session_start();

  echo $OrdersID = $_GET['id'];

  $sql ="UPDATE Orders
        SET OrdersStatus = '1'
        WHERE OrdersID=$OrdersID";

  $query = mysqli_query($objConnect,$sql);

  if (!$query) {

    header('location:error_page.php');
  }else{
      header('location:index.php');
  }


 ?>
