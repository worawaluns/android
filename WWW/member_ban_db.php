<?php
  require './connect.php';
  session_start();

  echo $CustomerID = $_GET['id'];

  $sql ="UPDATE Customer
                SET CustomerStatus='3'
                WHERE CustomerID=$CustomerID";
  $query = mysqli_query($objConnect,$sql);

  if (!$query) {

    header('location:error_page.php');
  }else{
      header('location:admin_member.php');
  }


 ?>
