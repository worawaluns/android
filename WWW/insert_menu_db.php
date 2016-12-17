<!-- //////////////////////////////////////////////////////////////// -->
<meta charset="utf-8">

<?php

      require './connect.php';
      session_start();

      echo $MenuName =$_POST['MenuName'];
      echo $MenuPrice = $_POST['MenuPrice'];
      echo $MenuDescription = $_POST['MenuDescription'];
      echo $MenuCal = $_POST['MenuCal'];
      echo $files = $_FILES['files'];


      $target_dir = "img/";
      $target_file = $target_dir . basename($_FILES["files"]["name"]);
      $uploadOk = 1;
      $imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
      // Check if image file is a actual image or fake image
      if(isset($_POST["submit"])) {
          $check = getimagesize($_FILES["files"]["tmp_name"]);

      }
      move_uploaded_file($_FILES["files"]["tmp_name"],$target_file);

      $sql ="INSERT INTO Menu (MenuName,MenuPrice,MenuDescription,MenuCal,MenuPic)
                    VALUES ('$MenuName','$MenuPrice','$MenuDescription','$MenuCal','$target_file')";

              $query = mysqli_query($objConnect,$sql);


                    				if (!$query) {

                    					header('location:error_page.php');
                    				}else{
                    						header('location:admin_menu.php');
                    				}


 ?>
