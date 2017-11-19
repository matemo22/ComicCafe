<?php
	include("connection.php");
	$response = array();
	if(isset($_POST['username']) && isset($_POST['password']) && isset($_POST['email']))
	{
		$username = $_POST['username'];
		$password = $_POST['password'];
		$email = $_POST['email'];
		$img_profile = $_POST['img_profile'];

		$sql = "SELECT * FROM User WHERE username = '$username'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result) > 0)
		{
			$response["code"] = 2;
			$response["message"] = "Username already exists!";
		}
		else
		{
			$sql_insert = "INSERT INTO User (username, password, email, img_profile) VALUES ('$username', '$password', '$email', '$img_profile')";
			if(mysqli_query($conn, $sql_insert)==true)
			{
				$response["code"] = 1;
				$response["message"] = "Registration Successful";
			}
			else
			{
				$response["code"] = -1;
				$response["message"] = "Registration Failed! Try Again!";
			}
		}
	}
	else
	{
		$response["code"] = -2;
		$response["message"] = "Data Tidak Lengkap";
	}
	echo json_encode($response);
?>