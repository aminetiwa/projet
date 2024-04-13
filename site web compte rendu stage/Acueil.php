<?php
//toujour en premier pour maintenir la connecion a la base de donner
session_start();
// Vérifiez si l'utilisateur est connecté
if (!isset($_SESSION["login"])) {
    // L'utilisateur n'est pas connecté, redirigez-le vers la page de connexion
    header("Location: index.php");
    exit();
}

// Inclusion du fichier de configuration '_conf.php' pour les paramètres de connexion à la base de données
include '_conf.php';

// Vérification si le formulaire de création de compte rendu a été soumis
if (isset($_POST['update'])) {
    // Connexion à la base de données MySQL
    $connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);

  
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Sanctuaire</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
</head>

<body>
<header>
        <h1>Stage Quest</h1>
    </header>
<nav>
  <a class="retro-button" href="#">Sanctuaire</a>
  <a class="retro-button" href="profil.php">profil</a>


   <?php
        //verifie si le type est un prof ou eleve 
        //0 pour prof
        if ($_SESSION["type"] == 0) {
            // Affiche le menu spécifique au professeur
            echo '<a class="retro-button" href="contact.php">Guerrier</a>';
          
            //si cest pas 0 cest un eleve
        } else {
            // Affiche le menu spécifique à l'élève
     
            echo '<a class="retro-button" href="compterendu.php">Epopée</a>';
        }
        ?>
    </ul>

    

</nav>
<div class="nes-container">
    <section id="potions">
    <?php
     //verifie si le type est un prof ou eleve 
        //0 pour prof
    if ($_SESSION["type"] == 0) {
        //salutaion pour le prof
        echo "Bienvenue Le super méga magistral, sa majesté le roi. <br><br>";
        echo '<img src="r.png" alt="Potion de Codage">'."<br>";
          //si cest pas 0 cest un eleve
    } else {
        //salutaion pour eleve
        echo "Vous êtes un chevalier tenebreux !<br>" .
"Préparez-vous pour une grande quête digne d'un grand, super méga, magistral, méga-super chevalier ténébreux !!!"."<br><br>";
echo '<img src="p.png" alt="Potion de Codage">'."<br>";

    }
    //fin de la condition donc affiche pour le prof et leleve le login
    echo "Vous vous nommez " . $_SESSION["login"] . "<br>";

    // Formulaire de déconnexion
    echo "<form method='post' action='deco.php'><button type='submit' name='deco'>Déconnexion</button></form>";
    ?>
       </section>
</div>
<footer>
        <p>&copy; 1990  Stage Quest. Tous droits réservés.</p>
    </footer>
</body>
</html>