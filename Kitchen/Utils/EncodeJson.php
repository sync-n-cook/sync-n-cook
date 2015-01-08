<?php

class EncodeJson{
 
    public  function getIngredientUrlandEncodeFic($url,$ficName){
        
           $json = file_get_contents($url);
           $frigo = fopen($ficName,'r+');
           fseek($frigo, 0);
           fputs($frigo, $json, strlen($json));            
           fclose($frigo);
           
    }
          
}
?>
