<?php 
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM userdata";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrUser = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["username"] = $row[1];
			$data["password"] = $row[2];
			$data["name"] = $row[3];
			$arrUser[$count] = $data;
			// $arrUser[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataUser"] = $arrUser;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>