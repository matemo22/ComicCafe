<?php
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM chapter_has_images";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrChapterHasImages = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["id_chapter"] = $row[1];
			$data["url"] = $row[2];
			$arrChapterHasImages[$count] = $data;
			// $arrChapterHasImages[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataChapterHasImages"] = $arrChapterHasImages;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>