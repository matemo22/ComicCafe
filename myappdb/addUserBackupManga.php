<?php
//HARUS DI EDIT
	include("connection.php");
	$response = array();
	if(isset($_POST['id_manga']) && isset($_POST['id_backup']))
	{
		$id_manga = $_POST['id_manga'];
		$id_backup = $_POST['id_backup'];

		$sql = "SELECT * FROM backup WHERE id_manga = '$id_manga'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result) > 0)
		{
			$sql_delete = "DELETE FROM backup WHERE id_manga = '$id_manga'";
			if(mysqli_query($conn, $sql_delete)==true){}
			else{}
		}
		$sql_insert = "INSERT INTO backup (id_manga) VALUES ('$id_manga')";
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