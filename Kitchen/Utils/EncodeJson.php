<?php

class EncodeJson{
 
    public  function getIngredientUrlandEncodeFic($url,$ficName){
        
           $json = file_get_contents($url);
//           file_put_contents($url, $json);
           $frigo = fopen($ficName,'r+');
           fseek($frigo, 0);
           fputs($frigo, $json, strlen($json));            
           fclose($frigo);
           
    }
    
    public function setIngId($array,$ficName){
        $json = json_encode($array);
        var_dump($json);
          var_dump($ficName);
        $frigo = fopen($ficName,'r+');
           fseek($frigo, 0);
           fputs($frigo, $json, strlen($json));            
           fclose($frigo);
        var_dump($json);
        
    }
          
}
?>
