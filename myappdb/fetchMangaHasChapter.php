<?php
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM manga_has_chapter";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrMangaHasChapter = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["id_manga"] = $row[1];
			$data["title"] = $row[2];
			$data["number"] = $row[3];
			$arrMangaHasChapter[$count] = $data;
			// $arrMangaHasChapter[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataMangaHasChapter"] = $arrMangaHasChapter;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>