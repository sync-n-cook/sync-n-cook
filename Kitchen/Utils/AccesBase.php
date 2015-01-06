<?php

class AccesBase{
    
    private $singletonInstance = null;
    private static $instance = null;
    
const DEFAULT_SQL_USER = 'user';
/**
* Constante: hôte de la bdd
*
* @var string
*/
const DEFAULT_SQL_HOST = 'localhost';
/**
* Constante: hôte de la bdd
*
* @var string
*/
const DEFAULT_SQL_PASS = 'xxxxxxxxx';
/**
* Constante: nom de la bdd
*
* @var string
*/
const DEFAULT_SQL_DTB = 'database';
    
public function  __construct(){
    try{
    $this->singletonInstance = new mysqli('localhost', 'my_user', 'my_password', 'world');
            //new PDO('mysql:dbname='.self::DEFAULT_SQL_DTB.';host='.self::DEFAULT_SQL_HOST,self::DEFAULT_SQL_USER ,self::DEFAULT_SQL_PASS);
    $this->singletonInstance->select_db('database');
    
    }
    catch(Exception $e){
        echo 'Erreur : '.$e->getMessage().'';
               echo 'N° : '.$e->getCode();       
               die();
    }

    }

  public function getInstance(){
    if(is_null(self::$instance))
    {
        self::$instance = new AccesBase();
    }
    return self::$instance;
      
    }
    
    
/**
* Exécute une requête SQL avec PDO
*
* @param string $query La requête SQL
* @return PDOStatement Retourne l'objet PDOStatement
*/
 public function init(){
      if(is_null(self::$instance))
    {
         new AccesBase();
    }
 }   
    
public function query($query)
{
    return $this->singletonInstance->query($query);
}
    
    
}
?>
