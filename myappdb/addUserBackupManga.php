<?php
//HARUS DI EDIT
	include("connection.php");
	$response = array();
	if(isset($_POST['id_manga']) && isset($_POST['id_backup']))
	{
		$id_manga = $_POST['id_manga'];
		$id_backup = $_POST['id_backup'];

		$sql_insert = "INSERT INTO user_backup_manga (id_backup, id_manga) VALUES ('$id_backup', '$id_manga')";
		if(mysqli_query($conn, $sql_insert)==true)
		{
			$response["code"] = 1;
			$response["message"] = "Backup Successful";
		}
		else
		{
			$response["code"] = -1;
			$response["message"] = "Backup Failed! Try Again!";
		}
	}
	else
	{
		$response["code"] = -2;
		$response["message"] = "Data Tidak Lengkap";
	}
	echo json_encode($response);
?>