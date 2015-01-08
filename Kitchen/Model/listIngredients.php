<?php

	$dir = 'sqlite:/[YOUR-PATH]/combadd.sqlite';
	$dbh  = new PDO($dir) or die("cannot open the database");
	$query =  "SELECT * FROM ingredients";
        $ing = array();
	foreach ($dbh->query($query) as $row)
	{
		echo $row[0];
                $ing[] =$row; 
                
	}
        
        echo json_encode($ing);


?>