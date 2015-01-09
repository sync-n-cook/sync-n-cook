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
        $conf = new Conf();
          list($serveur,$port) = $conf->getConf("../../servConf.json");
        
        $url = 'http://'.$serveur[0].':'.$port[0].'/ProjetIntensif/webapi/ingredient/';
      
        list($ingredientName,$ingredientQuantity) = $json->decodeIngredient($url);
        unset($json);
        return array( $ingredientName, $ingredientQuantity);
    } 
}

?>
