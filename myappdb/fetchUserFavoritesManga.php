<?php 
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM user_favorites_manga";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrUserFavoritesManga = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["id_user"] = $row[1];
			$data["id_manga"] = $row[2];
			$arrUserFavoritesManga[$count] = $data;
			// $arrUserFavoritesManga[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataUserFavoritesManga"] = $arrUserFavoritesManga;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>