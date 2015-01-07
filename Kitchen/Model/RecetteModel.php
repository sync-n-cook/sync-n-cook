<?php
require_once "../utils/AccesBase.php";
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class RecetteModel{
    
    public static function getIngredient(){
        $sql = "SELECT ingredientNom, ingredientQuantite
                FROM  recette
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
