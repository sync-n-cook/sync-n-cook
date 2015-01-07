<?php
require_once "../Model/IngredientsModel.php";
require_once "../Utils/DecodeJson.php";
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class IngredientBuisness{
    


    public  function getIngredientJson(){
        $json =  new DecodeJson();
        list($ingredientName,$ingredientQuantity) = $json->decodeIngredient("../frigo.json");
        return array( $ingredientName, $ingredientQuantity);
    } 
}

?>
