<?php
	$servername = "fdb6.runhosting.com";
	$username = "2534932_comiccafe";
	$password = "mobileapps1";
	$dbname = "2534932_comiccafe";

	$conn = mysqli_connect($servername, $username, $password, $dbname);

	if(!$conn)
	{
		die("Koneksi gagal : ".mysqli_connect_error());
	}
?>