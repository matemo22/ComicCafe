<?php
	include("connection.php");
	$response = array();
	if(isset($_POST['id_user']))
	{
		$id_user = $_POST['id_user'];

		$sql = "SELECT * FROM backup WHERE id_user = '$id_user'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result) > 0)
		{
			$sql_delete = "DELETE FROM backup WHERE id_user = '$id_user'";
			if(mysqli_query($conn, $sql_delete)==true){}
			else{}
			$sql_delete = "DELETE FROM user_backup_manga WHERE id_backup = '$id_backup'";
			if(mysqli_query($conn, $sql_delete)==true){}
			else{}
		}
		$sql_insert = "INSERT INTO backup (id_user) VALUES ('$id_user')";
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