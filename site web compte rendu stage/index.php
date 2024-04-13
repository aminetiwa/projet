<?php

require('conf.php');


// Vérification de la connexion à la base de données
if (!$conn) {
    die("Erreur de connexion à la base de données : " . mysqli_connect_error());
}
//toujour en premier pour maintenir la connecion a la base de donner
session_start();
if (isset($_POST['btn_connexion'])) {

    // Récupération des informations saisie dans les case login et mot de passe quand je clique sur le bouton se connecter 
    $login = isset($_POST["login"]) ? $_POST["login"] : "";
    $mdp = isset($_POST["mdp"]) ? $_POST["mdp"] : "";

    // Requête sql pour récupérer l'utilisateur correspondant au login
    $requete = "SELECT * FROM UTILISATEUR WHERE login='$login'";
   
    // stocke le resultat de la requete en haut dans $resultat
    $resultat = $conn->query($requete);

    // Vérification du résultat de la requête vérifie si la requête a renvoyé exactement une seule ligne de résultat
    //simplifier verifie si la requete retourne 1 seul login 
    //si il y a 0 login ou plus de 1 login ecemple :2,3,4... cest faux 
    if ($resultat->num_rows == 1) {
        // L'utilisateur a été trouvé dans la base de données, on vérifie le mot de passe
        $utilisateur = $resultat->fetch_assoc();
        //verifie si le hachage du mot de passe stocker dans la bd coresspond au hachage du mot de passe saisie
        if (password_verify($mdp, $utilisateur['motdepasse'])) {
            // Le mot de passe est correct, on crée une session pour le connecter

            $_SESSION["login"] = $utilisateur["login"];
            $_SESSION["nom_u"] = $utilisateur["nom"];
             $_SESSION["num_u"] = $utilisateur["num"];
            $_SESSION["type"] = $utilisateur["type"];
            $_SESSION["id"] = $utilisateur["id"];
            
         
        
            // Redirection vers la page d'accueil

            header("Location: Acueil.php");

            exit();
        } else {
            // Le mot de passe est incorrect, on affiche un message d'erreur
            echo "<p class='error'>Votre Mot De Passe est incorrect.</p>";
        }
    } else {
        // L'utilisateur n'a pas été trouvé dans la base de données, on affiche un message d'erreur
        echo "<p class='error'>Votre Email est incorrect.</p>";
    }
    
}

// Déplacez le message de connexion réussie ici, après les opérations précédentes
$conn->close(); // Fermeture de la connexion à la base de données
?>

<!DOCTYPE html>
<html>
<head>
    <title>Pont virtuel</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
</head>
<body>
<header>
        <h1>Stage Quest</h1>
 
    </header>
           <nav>
  <a class="retro-button" href="#">Sanctuaire</a>
  </nav>
<div class="nes-container">
    <h1>Pont Virtuel</h1>
   <section>
    <form method="post" action="">
        <label for="login">Identiter Numerique:</label>
        <input class="retro-input" type="text" id="login" name="login" required>
           <br>
        <label for="mdp">Le Sceau Secret :</label>
        <input class="retro-input" type="password" id="mdp" name="mdp" required>
           <br>
        <button class="retro-button" type="submit" name="btn_connexion">Sésame Ouvre-Toi</button>
         <a href="oublier.php" class="contact-button">La Quête Du Sésame Perdu</a>
    </section>
   
    </form>

</div>
     <footer>
        <p>&copy; 1990 Stage Quest. Le Gardien des récits.</p>
    </footer>
</body>
</html>
