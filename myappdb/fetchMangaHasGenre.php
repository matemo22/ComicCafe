<?php
	include("connection.php");
	$response = array();
	$sql = "SELECT * FROM manga_has_genre";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result) > 0)
	{
		$data = array();
		$arrMangaHasGenre = array();
		$count = 0;
		while($row = mysqli_fetch_array($result))
		{
			$data["id"] = $row[0];
			$data["id_manga"] = $row[1];
			$data["id_genre"] = $row[2];
			$arrMangaHasGenre[$count] = $data;
			// $arrMangaHasGenre[$count] = $row;
			$count++;
		}
		mysqli_free_result($result);
		$response["code"] = 1;
		$response["message"] = "Success";
		$response["dataMangaHasGenre"] = $arrMangaHasGenre;
	}
	else
	{
		$response["code"] = 2;
		$response["message"] = "Failed";
	}
	echo json_encode($response);
?>