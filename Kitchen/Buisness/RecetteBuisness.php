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
     
      $o=0;//indice du tableau 1
      $off = 0;//indice du tableau 2
        for($o = 0 ; $o < count($array) ; $o++){
            for($offset = 0; $offset < count($array[$o]); $offset++){
        
                $cleanArray[$off] = $array[$o][$offset]; // reduction du tableau a 2 dimension à une 1 dimension
                $off++;
            }
        }
        
        return array_unique($cleanArray);//efface les doublons
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
    
    public function getRecetteFav(){
         $json =  new DecodeJson();
           list($recetteName,$recetteDesc) = $json->decodeRecetteFav("../recetteFav.json");
        return array( $recetteName, $recetteDesc);
    }
}

?>
