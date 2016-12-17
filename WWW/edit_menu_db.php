<!-- //////////////////////////////////////////////////////////////// -->
<meta charset="utf-8">

<?php

      require './connect.php';
      session_start();

      echo $MenuID =$_POST['MenuID'];
      echo $Name = $_POST['Name'];
      echo $Calories = $_POST['Calories'];
      echo $Price = $_POST['Price'];
      echo $Detail = $_POST['Detail'];
      echo $files = $_FILES['files'];


      $target_dir = "img/";
      $target_file = $target_dir . basename($_FILES["files"]["name"]);
      $uploadOk = 1;
      $imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
      // Check if image file is a actual image or fake image
      if(isset($_POST["submit"])) {
          $check = getimagesize($_FILES["files"]["tmp_name"]);

      }
      move_uploaded_file($_FILES["files"]["tmp_name"], $target_file);

                    $sql ="UPDATE Menu
                    SET MenuName='$Name',MenuPrice='$Price',MenuDescription='$Detail',MenuCal='$Calories',MenuPic='$target_file'
                    WHERE MenuID=$MenuID";

                    $query = mysqli_query($objConnect,$sql);


                    				if (!$query) {

                    					header('location:error_page.php');
                    				}else{
                    						header('location:admin_menu.php');
                    				}


 ?>
