<?php
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM genre";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrGenre = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["name"] = $row[1];
			$arrGenre[$count] = $data;
			// $arrGenre[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataGenre"] = $arrGenre;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>