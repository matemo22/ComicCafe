<?php
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM manga";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrManga = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["name"] = $row[1];
			$data["author"] = $row[2];
			$data["status"] = $row[3];
			$data["img_cover"] = $row[4];
			$data["description"] = $row[5];
			$arrManga[$count] = $data;
			// $arrManga[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataManga"] = $arrManga;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>