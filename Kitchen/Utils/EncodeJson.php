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
//        var_dump($json);
//             var_dump($array);
//                  var_dump($ficName);
//        $frigo = fopen($ficName,'r+');
//        ftruncate($frigo,0);
//           fseek($frigo, 0);
//         $i=  fputs($frigo, $json, strlen($json));            
//           fclose($frigo);
   
       
      $ret =   file_put_contents($ficName, $json);
       
        var_dump($ret);
        
    }
          
}
?>
