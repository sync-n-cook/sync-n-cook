<?php

class DecodeJson{
 
    public  function decodeIngredient($ficName){
        $json = file_get_contents($ficName);
        $offset=0;
     $ingredientName = array();
     $ingredientQuantity = array();
        $parsed_json = json_decode($json);
        foreach($parsed_json as $par){
        $ingredientName[$offset] = $parsed_json[$offset]->ingredientNom;
       $ingredientQuantity[$offset] = $parsed_json[$offset]->ingredientQuantite;
       //    print (($ingredientName[$offset]));
              //   print (($ingredientQuantity[$offset]));
           $offset++;
        }
        return array($ingredientName,$ingredientQuantity);
     
    }
    
    public function decodeRecette($url){
        $json = file_get_contents($url);
        $offset=0;
        
        $recetteName = array();
        $recetteDescription = array();
        $recetteId = array();
       
        $parsed_json = json_decode($json);
        
         if(isset($parsed_json)|| sizeof($parsed_json)>0){
          
            foreach($parsed_json as $par){
               $recetteName[$offset] = $parsed_json[$offset]->recetteNom;
           
               $recetteDescription[$offset] = $parsed_json[$offset]->recetteDescription;
               $recetteId[$offset] = $parsed_json[$offset]->recetteId;
               $offset++;
            }
              
             return array($recetteName,$recetteDescription,$recetteId);
           }
         return null;
 
    }
    
    public function getIngId($ficName){
        $json = file_get_contents($ficName);
        $offset=0;
        $ingredientId = array();
        
        $parsed_json = json_decode($json);
        foreach($parsed_json as $par){
        $ingredientId[$offset] = $parsed_json[$offset]->ingredientId;
           $offset++;
        }
        return $ingredientId;

    }
          
   
    public function decodeRecetteFav($ficName){
        $json = file_get_contents($ficName);
        $offset=0;
        
        $recetteName = array();
        $recetteDescription = array();
    
       
        $parsed_json = json_decode($json);
        
         if(isset($parsed_json)|| sizeof($parsed_json)>0){
          
            foreach($parsed_json as $par){
               $recetteName[$offset] = $parsed_json[$offset]->recetteNom;
               $recetteDescription[$offset] = $parsed_json[$offset]->recetteDescription;
               $offset++;
            }
              
             return array($recetteName,$recetteDescription);
           }
         return null;
 
    }
    
}
?>
