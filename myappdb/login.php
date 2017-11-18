<?php
	include("connection.php");
	$response = array();
	if(isset($_POST["username"]) && isset($_POST["password"]))
	{
		$username = $_POST["username"];
		$password = $_POST["password"];
		$sql = "SELECT * FROM userdata WHERE username = '$username' AND password = '$password'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result)>0)
		{
			$response["code"] = 1;
			$response["message"] = "Login Berhasil";
		}
		else
		{
			$response["code"] = -1;
			$response["message"] = "Login Gagal";
		}
	}
	else
	{
		$response["code"] = -2;
		$response["message"] = "Data tidak lengkap";
	}
	echo json_encode($response);
?>