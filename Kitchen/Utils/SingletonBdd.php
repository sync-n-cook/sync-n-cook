<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class SingletonBdd extends PDO{
   
    /**
   * Constructeur
   *
   * @param string $path
   * @param string $user
   * @param string $path
   * @return void
   * @access private
   * @see PDO::__construct()
   */
   private function __construct($path, $user, $pass)
   {
     parent::__construct($path, $user, $pass);
   }
}
?>
