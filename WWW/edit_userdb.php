<!-- //////////////////////////////////////////////////////////////// -->
<meta charset="utf-8">

<?php

      require './connect.php';
      session_start();

      echo $CustomerID =$_POST['CustomerID'];
      echo $CustomerUsername =$_POST['CustomerUsername'];
      echo $CustomerFullname = $_POST['CustomerFullname'];
      echo $CustomerTel = $_POST['CustomerTel'];
      echo $CustomerEmail = $_POST['CustomerEmail'];
      $files = $_POST['files'];



      $target_dir = "img/";
      $target_file = $target_dir . basename($_FILES["files"]["name"]);
      $uploadOk = 1;
      $imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
      // Check if image file is a actual image or fake image
      if(isset($_POST["submit"])) {
          $check = getimagesize($_FILES["files"]["tmp_name"]);

      }
      move_uploaded_file($_FILES["files"]["tmp_name"], $target_file);

                    $sql ="UPDATE Customer
                    SET CustomerUsername='$CustomerUsername',CustomerFullname='$CustomerFullname',CustomerTel='$CustomerTel',CustomerEmail='$CustomerEmail',CustomerPic='$target_file'
                    WHERE CustomerID=$CustomerID";

                    $query = mysqli_query($objConnect,$sql);


                    				if (!$query) {

                    					// header('location:error_page.php');
                    				}else{
                    						header('location:admin_member.php');
                    				}


 ?>
