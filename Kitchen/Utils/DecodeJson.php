<?php

class DecodeJson{
 
    public  function decode($ficName){
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
          
}
?>
