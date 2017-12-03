<?php
	include("connection.php");
	$response = array();
	if(isset($_POST['id_user']) && isset($_POST['id_manga']))
	{
		$id_user = $_POST['id_user'];
		$id_manga = $_POST['id_manga'];

		$sql = "SELECT * FROM user_likes_manga WHERE id_user = '$id_user' AND id_manga = '$id_manga'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result) > 0)
		{

			$response["code"] = 2;
			$sql_delete = "DELETE FROM user_likes_manga WHERE id_user = '$id_user' AND id_manga = '$id_manga'";
			if(mysqli_query($conn, $sql_delete)==true)
			{
				$response["code"] = 3;
				$response["message"] = "Dislike Successful";
			}
			else
			{
				$response["code"] = -3;
				$response["message"] = "Dislike Failed! Try Again!";
			}
		}
		else
		{
			$sql_insert = "INSERT INTO user_likes_manga (id_user, id_manga) VALUES ('$id_user', '$id_manga')";
			if(mysqli_query($conn, $sql_insert)==true)
			{
				$response["code"] = 1;
				$response["message"] = "Like Successful";
			}
			else
			{
				$response["code"] = -1;
				$response["message"] = "Like Failed! Try Again!";
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