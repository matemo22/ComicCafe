<?php
	include("connection.php");
	if(isset($_POST['username']) && isset($_POST['password']) && isset($_POST['name']))
	{
		$username = $_POST['username'];
		$password = $_POST['password'];
		$name = $_POST['name'];

		$sql = "SELECT * FROM userdata WHERE username = '$username'";
		$result = mysqli_query($conn, $sql);
		if(mysqli_num_rows($result) > 0)
		{
			echo "Username sudah ada";
		}
		else
		{
			$sql_insert = "INSERT INTO userdata (username, password, name) VALUES ('$username', '$password', '$name')";
			if(mysqli_query($conn, $sql_insert)==true)
			{
				echo "Registrasi Berhasil";
			}
			else
			{
				echo "Registrasi Gagal";
			}
		}
	}
	else
	{
		echo "Data tidak lengkap";
	}
?>