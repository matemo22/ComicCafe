<?php 
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM backup";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrBackup = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["id_user"] = $row[1];
			$data["date"] = $row[2];
			$arrBackup[$count] = $data;
			// $arrBackup[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataBackup"] = $arrBackup;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>