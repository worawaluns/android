<?php
	require_once("dbconnect.php");
	$getcal = $_GET['source'];

	if ($getcal == 1) {
		$sql = "SELECT * FROM Menu ORDER BY Menu.MenuCal ASC";
	}else{
		$sql = "SELECT * FROM Menu ORDER BY Menu.MenuCal DESC";
	}

	$result = mysqli_query($link, $sql);
	// $row_cnt = mysqli_num_rows($result);

	// echo 'row = '.$row_cnt;
	// $row = mysqli_fetch_array($result);
	//echo $row['user_id']." : ";
	//echo $row['username'];
	//$i = 0;

	$resultArray = array();
	while($results = mysqli_fetch_array($result,MYSQLI_ASSOC)){
		// echo $results;
		array_push($resultArray,$results);
	}

	echo json_encode($resultArray);

	// echo "[";
	// $i = 0;
	// foreach ($result as $results) {
	// 				// $MenuID = $results["MenuID"];
	// 				// $MenuPic = $results["MenuPic"];
	// 				// $MenuName = $results["MenuName"];
	// 				// $MenuPrice = $results["MenuPrice"];
	// 				// $MenuDescription = $results["MenuDescription"];
	// 				// $MenuCal = $results["MenuCal"];

	// 				echo json_encode($results);

	// 				$i++;


	// 				// echo $i.'---'.($row_cnt - 1);
	// 				if($i != ($row_cnt) )
	// 					echo ",";

	// 				// $i++;
	// }

	// echo "]";
	// //$i++;

	// $total = sizeof($result);

	// echo $total;

	 
?>