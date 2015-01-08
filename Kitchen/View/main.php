<?php
require_once "../Utils/AccesBase.php";
require_once '../Utils/EncodeJson.php';
require_once '../Buisness/RecetteBuisness.php';

if (isset($_GET["kitchen"])) {
    header('Location: ./Kitchen.html');
    exit();
}else{
    
    $nom = array();
    $valeur = array();
foreach ($_GET as $nomchamp => $valeurchamp) 
		{   
			if (!empty($valeurchamp)) 
			{       $nom[] = $nomchamp;
                                $valeur[] = $valeurchamp;
                            
			}
		}
                                var_dump( $nom);
			
				var_dump( $valeur);
                                if($nom[0]=="id0"){
                                   
                                    $encode = new EncodeJson();
                                    $encode->setIngId($valeur, "../ingId.json");
                                     header('Location: ./Kitchen.html');
                                     exit();
                                }
}



?>
