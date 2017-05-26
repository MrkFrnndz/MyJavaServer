<?php
/**
 * Database config variables
 */
define("DB_HOST", "mysql.hostinger.ph");
define("DB_USER", "u960796914_mark");
define("DB_PASSWORD", "DqbvftFee0hY");
define("DB_DATABASE", "u960796914_mydb");

$db = mysqli_connect(DB_HOST,DB_USER,DB_PASSWORD,DB_DATABASE);
	
	if($db == false){
		echo "No connection";
	}                        
?>