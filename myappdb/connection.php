<?php
	$servername = "localhost";
	$username = "id3648778_comiccafe";
	$password = "mobileapps1";
	$dbname = "id3648778_comiccafe";

	$conn = mysqli_connect($servername, $username, $password, $dbname);

	if(!$conn)
	{
		die("Koneksi gagal : ".mysqli_connect_error());
	}
?>