<?php

class Conf{
    
    public function getConf($ficName){
        
     $json = file_get_contents($ficName);
 
     
     $offset=0;
     $addresseServeur = array();
     $port = array();
     
     $parsed_json = json_decode($json);

     
     foreach($parsed_json as $par){
     $addresseServeur[$offset] = $parsed_json[$offset]->AdresseServeur;
     $port[$offset] = $parsed_json[$offset]->Port;
           $offset++;
        }
        return array($addresseServeur,$port);
        
    }
 
}
?>
