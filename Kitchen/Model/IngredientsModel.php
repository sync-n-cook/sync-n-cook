<?php
require_once "../Utils/AccesBase.php";
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class IngredientsModel{
    
    public static function getIngredient(){
        $sql = "SELECT ingredientNom, ingredientQuantite
                FROM  ingredient
                ";
      $bdd = new AccesBase();
      $stmt = $bdd->getInstance();
      $stmt->prepare($sql);
      //$stmt->bind_param('sssd', $code, $language, $official, $percent);
      $stmt->execute();
      $stmt->fetch();
      $stmt->close(); 
      return array($name,$quantity);
      
    }
   
}

?>
