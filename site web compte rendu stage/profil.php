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
include 'conf.php';

// Vérification si le formulaire de création de compte rendu a été soumis
if (isset($_POST['update'])) {
    // Connexion à la base de données MySQL
    $connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);

  
}
  $login = $_SESSION["login"];
 // Maintenant, récupérez le champ 'num_stage' associé à l'utilisateur depuis la base de données
     
// Récupérer le champ 'num_stage' associé à l'utilisateur depuis la base de données
$requeteStage = "SELECT num_stage FROM UTILISATEUR WHERE login='$login'";
$resultatStage = $conn->query($requeteStage);

if ($resultatStage->num_rows == 1) {
    $row = $resultatStage->fetch_assoc();
    $numStage = $row["num_stage"];

    // Récupérer les données de la table STAGE pour l'utilisateur connecté
    $requeteStageUtilisateur = "SELECT * FROM STAGE WHERE num = '$numStage'";
    $resultatStageUtilisateur = $conn->query($requeteStageUtilisateur);

    if ($resultatStageUtilisateur->num_rows == 1) {
        $rowStage = $resultatStageUtilisateur->fetch_assoc();
        $_SESSION["nom_stage"] = $rowStage["nom"];
        $_SESSION["adresse_stage"] = $rowStage["adresse"];
        $_SESSION["ville_stage"] = $rowStage["ville"];
        $_SESSION["tel_stage"] = $rowStage["tel"];
        $_SESSION["libelleStage"] = $rowStage["libelleStage"];
        $_SESSION["email_stage"] = $rowStage["email"];
        $_SESSION["num_tuteur"] = $rowStage["num_tuteur"];

        // Récupérer les données de la table TUTEUR pour l'utilisateur connecté
        $requeteTuteur = "SELECT * FROM TUTEUR WHERE num = '" . $rowStage["num_tuteur"] . "'";
        $resultatTuteur = $conn->query($requeteTuteur);

        if ($resultatTuteur->num_rows == 1) {
            $rowTuteur = $resultatTuteur->fetch_assoc();
            $_SESSION["nom_tuteur"] = $rowTuteur["nom"];
            $_SESSION["prenom_tuteur"] = $rowTuteur["prenom"];
            $_SESSION["tel_tuteur"] = $rowTuteur["tel"];
            $_SESSION["email_tuteur"] = $rowTuteur["email"];
        }
    }
} else {
    echo "Erreur lors de la requête SQL : " . $conn->error;
}

        
?>

<html>
<head>
    <title>Sanctuaire </title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
</head>
<body>
    <header>
        <h1>Stage Quest</h1>
 
    </header>
<nav>
  <a class="retro-button" href="Acueil.php">Sanctuaire</a>
  <a  class="retro-button" href="profil.php">profil</a>

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
       if ($_SESSION["type"] == 1) {
    // Affiche les informations du stage
 echo "<h2>Informations du Stage</h2>";
    echo "Nom de la Quête Stage: " . $_SESSION["nom_stage"] . "<br>";
    echo "Repère: " . $_SESSION["adresse_stage"] . "<br>";
    echo "Ville: " . $_SESSION["ville_stage"] . "<br>";
    echo "Porte-voix numérique de la Quête du STAGE: " . $_SESSION["tel_stage"] . "<br>";
    echo "Libellé du Stage: " . $_SESSION["libelleStage"] . "<br>";
    echo "Enveloppe-numérique de la Quête du Stage: " . $_SESSION["email_stage"] . "<br><br>";

    // Affiche les informations du tuteur
      echo "<h2>Informations du Chevalier-Mentorius</h2>";
    echo "Nom du Chevalier-Mentorius: " . $_SESSION["nom_tuteur"] . "<br>";
    echo "Prénom du Chevalier-Mentorius: " . $_SESSION["prenom_tuteur"] . "<br>";
    echo "Porte-voix numérique du Chevalier-Mentorius: " . $_SESSION["tel_tuteur"] . "<br>";
    echo "Enveloppe-numérique du Chevalier-Mentorius: " . $_SESSION["email_tuteur"] . "<br><br>";
    echo '<img src="t.png" alt="Potion de Codage">'."<br>";

}
 
     //verifie si le type est un prof ou eleve 
        //0 pour prof
    if ($_SESSION["type"] == 0) {
         echo "<h1>Mon Profil</h1>";
        //salutaion pour le prof
        echo "Bienvenue sur le compte professeur <br><br>";

    }
    //fin de la condition donc affiche pour le prof et leleve le login
    echo "<br>Vous êtes connecté en tant que " . $_SESSION["login"] . "<br><br>";

    // Formulaire de déconnexion
    echo "<form method='post' action='deco.php'><button type='submit' name='deco'>Déconnexion</button></form>";
    ?>
</section>
 
    </div>
  
</body>
</html>