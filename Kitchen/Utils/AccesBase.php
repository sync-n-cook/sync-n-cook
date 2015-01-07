<?php

class AccesBase{
    
 private $singletonInstance = null;
 
 private static $instance = null;
    
 protected $sqlUser = 'user';
/**
* Constante: hôte de la bdd
*
* @var string
*/
 protected $sqlHost = 'localhost';
/**
* Constante: hôte de la bdd
*
* @var string
*/
protected $sqlPass = 'xxxxxxxxx';
/**
* Constante: nom de la bdd
*
* @var string
*/
protected $sqlDatabase = 'database';
    
public function  __construct(){
  
    $this->singletonInstance = new mysqli($this->sqlUser, $this->sqlHost, $this->sqlPass, 'world');
            //new PDO('mysql:dbname='.self::DEFAULT_SQL_DTB.';host='.self::DEFAULT_SQL_HOST,self::DEFAULT_SQL_USER ,self::DEFAULT_SQL_PASS);
    $this->singletonInstance->select_db($this->sqlDatabase);
    
    if ($this->singletonInstance->connect_error) {
    die('Erreur de connexion (' . $this->singletonInstance->connect_errno . ') '
            . $this->singletonInstance->connect_error);
    
    $this->singletonInstance->close();
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
