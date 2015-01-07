<?php
require_once "../Model/IngredientsModel.php";
require_once "../Utils/DecodeJson.php";
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class RecetteBuisness{
    

    private function cleanArray($array){
     $cleanArray = array();
     
      $o=0;
      $off = 0;
        for($o = 0 ; $o < count($array) ; $o++){
            for($offset = 0; $offset < count($array[$o]); $offset++){
        
                $cleanArray[$off] = $array[$o][$offset];
                $off++;
            }
        }
        
        $offset = 0;
        foreach ($cleanArray as $clean){
         
            $offset++;
        }
        return array_unique($cleanArray);
    }
    
    

    public  function RecetteJson(){
        $json =  new DecodeJson();
        $recetteName = array();
        $recetteDescription = array();
     
        $offset = 0;
      
       $ingredientId = $json->getIngId("../frigo.json");
       foreach($ingredientId as $id){
           $url = 'http://serveur-apprentissage.ensicaen.fr:8080/ProjetIntensif/webapi/recette/ingredient/'.$id;
          
           list($Name,$Description,$recetteId) = $json->decodeRecette($url);
      
           if(sizeof($Name)>0 && sizeof($Description)>0){
        
            $recetteName[$offset] = $Name;
            $recetteDescription[$offset] = $Description;      
            $recetteId[$offset] = $id;
            
        
               $offset++;
            }
         
        }
   
       $r = $this->cleanArray($recetteName);
       $rd = $this->cleanArray($recetteDescription);
 

        return array( $r, $rd);
    }
}

?>
