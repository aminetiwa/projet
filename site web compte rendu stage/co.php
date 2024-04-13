<?php
require('conf.php');

$bdd = "id20196766_projet_amine";

if (isset($_POST['username']) && isset($_POST['mdp'])){
  $login = mysqli_real_escape_string($conn, stripslashes($_POST['username']));
  $mdp = mysqli_real_escape_string($conn, stripslashes($_POST['mdp']));
  
  $query = "SELECT * FROM `utilisateur` WHERE login='$login' AND mdp='$mdp'";
  $result = mysqli_query($conn, $query) or die(mysqli_error($conn));
  $rows = mysqli_num_rows($result);
  
  if($rows == 1){
      session_start();
      $_SESSION['login'] = $login;
      header("Location: index.php");
      exit();
  }else{
    echo "Le nom d'utilisateur ou le mot de passe est incorrect.";
  }
}
?>

<html>
<head>
	<title>Page de Connexion </title>
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<nav>
  <a href="#">Accueil</a>
  <a class="active"  href="connexion.php">Se connecter</a>
  <a href="ins.php">S'inscrire</a>
  <div class="menu">&#9776;</div>
</nav>
  <div class="menu">&#9776;</div>
</nav>
	<div class="nes-container">
		<h1>Connexion</h1>
		<form>
			<label for="username">Nom d'utilisateur:</label>
			<input type="text" id="username" name="username" required>
			<label for="password">Mot de passe:</label>
			<input type="password" id="mdp" name="mdp" required>
			<button type="submit">Se connecter</button>
		</form>
	</div>
</body>
</html>