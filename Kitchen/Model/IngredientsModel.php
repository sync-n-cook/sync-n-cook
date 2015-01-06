<?php
require_once "../utils/AccesBase.php";
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class IngredientsModel{
    
    public function getIngredient(){
        $sql = "SELECT
                FROM
                WHERE";
      $stmt = AccesBase::getInstance();
      $stmt = $mysqli->prepare("INSERT INTO CountryLanguage VALUES (?, ?, ?, ?)");
      $stmt->bind_param('sssd', $code, $language, $official, $percent);
      $stmt->close(); 
      $stmt->execute();
     
      return array($ingredient);
    }
    
}

?>
