<?php
require_once "../Utils/AccesBase.php";
require_once '../Utils/EncodeJson.php';
if (isset($_GET["kitchen"])) {
    header('Location: ./Kitchen.html');
    exit();
}
else if(isset($_GET["ingredient"])){
    $encode = new EncodeJson();
    $encode->getIngredientUrlandEncodeFic("../frigo.json", "../frigo.json");
    header('Location: ./Kitchen.html');
    exit();
}


?>
