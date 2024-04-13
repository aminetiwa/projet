<!DOCTYPE html>
<html>
<head>
    <title>Contact</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
</head>
<body>
    <header>
        <h1>Stage Quest</h1>
 
    </header>
<nav>
  <a class="retro-button" href="Acueil.php">Sanctuaire</a>
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
     
            echo '<a  class="retro-button"  href="compterendu.php">Epopée</a>';
        }
        ?>
        </nav>
<!DOCTYPE html>
<html>
<head>
    <title>Messagerie</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="nes-container">
    <h1>Message</h1>
    <?php
    // Connectez-vous à la base de données
         
    require('conf.php');

    $bdd = "id20196766_projet_amine";
    if ($conn->connect_error) {
        die("Échec de la connexion à la base de données : " . $conn->connect_error);
    }

    // Récupérez l'ID de l'utilisateur actuel (vous devrez gérer l'authentification)
    $utilisateur_actuel = 1; // Remplacez par l'ID de l'utilisateur connecté

    // Récupérez l'ID du destinataire à partir de la requête GET
    $destinataire = $_GET["destinataire"];

    // Récupérez les messages entre l'utilisateur actuel et le destinataire
    $sql = "SELECT * FROM Messages WHERE (expediteur = $utilisateur_actuel AND destinataire = $destinataire) OR (expediteur = $destinataire AND destinataire = $utilisateur_actuel) ORDER BY date_envoi";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $expediteur = $row["expediteur"];
            $message = $row["message"];
            echo "<p><strong>Utilisateur $expediteur :</strong> $message</p>";
        }
    } else {
        echo "<p>Pas de messages.</p>";
    }

    // Formulaire pour envoyer un message
    ?>
    <form action="emsg.php" method="post">
        <input type="hidden" name="destinataire" value="<?php echo $destinataire; ?>">
        <label for="message">Message :</label>
        <input type="text" id="message" name="message" required>
        <input type="submit" value="Envoyer">
    </form>
</body>
</html>
</div>
<!-- msg.php -->
<!DOCTYPE html>
<html>
<head>
    <title>Epopée-Légendaire des Chevaliers Tenebreux</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
     <div class="nes-container">
    <h1>Stage</h1>
    <!-- troisième partie - Affichage des données de STAGE et TUTEUR -->
<?php


// Récupérer le champ 'num_stage' associé à l'utilisateur depuis la base de données
$requeteStage = "SELECT num_stage FROM UTILISATEUR WHERE num='$destinataire'";
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

<h2>Données de la Quéte du  STAGE</h2>
<?php

 
     

    
        // Affiche les informations du stage
    echo "<h2>Informations du Stage</h2>";
    echo "Nom de la Quête Stage: " . $_SESSION["nom_stage"] . "<br>";
    echo "Repère: " . $_SESSION["adresse_stage"] . "<br>";
    echo "Ville: " . $_SESSION["ville_stage"] . "<br>";
    echo "Porte-voix numérique de la Quête du STAGE: " . $_SESSION["tel_stage"] . "<br>";
    echo "Libellé du Stage: " . $_SESSION["libelleStage"] . "<br>";
    echo "Enveloppe-numérique de la Quête du Stage: " . $_SESSION["email_stage"] . "<br><br>";

    echo "</table>";

?>

<h2>Données du Chevalier-Mentorius</h2>
<?php
    // Affiche les informations du tuteur
    echo "<h2>Informations du Chevalier-Mentorius</h2>";
    echo "Nom du Chevalier-Mentorius: " . $_SESSION["nom_tuteur"] . "<br>";
    echo "Prénom du Chevalier-Mentorius: " . $_SESSION["prenom_tuteur"] . "<br>";
    echo "Porte-voix numérique du Chevalier-Mentorius: " . $_SESSION["tel_tuteur"] . "<br>";
    echo "Enveloppe-numérique du Chevalier-Mentorius: " . $_SESSION["email_tuteur"] . "<br><br>";

?>
</div>
    <div class="nes-container">
    <h1>Epopée-Légendaire du Chevalier Tenebreux</h1>
    <?php
    require('conf.php');

    if ($conn->connect_error) {
        die("Échec de la connexion à la base de données : " . $conn->connect_error);
    }

    if (isset($_GET['destinataire']) && is_numeric($_GET['destinataire'])) {
        $destinataire_id = $_GET['destinataire'];

        // Récupérez le nom de l'utilisateur sélectionné
        $sql_nom = "SELECT nom FROM UTILISATEUR WHERE num = $destinataire_id";
        $result_nom = $conn->query($sql_nom);

        if ($result_nom->num_rows > 0) {
            $row_nom = $result_nom->fetch_assoc();
            echo "<h2>Epopée-legendaire du chevalier Tenebreux nommer " . $row_nom["nom"] . "</h2>";
        }

        // Récupérez les comptes rendus de l'utilisateur
        $sql_comptes_rendus = "SELECT date, description FROM CR WHERE num_utilisateur = $destinataire_id";
        $result_comptes_rendus = $conn->query($sql_comptes_rendus);

        if ($result_comptes_rendus->num_rows > 0) {
            echo "<ul>";
            while ($row_compte_rendu = $result_comptes_rendus->fetch_assoc()) {
                echo "<li>Epoque : " . $row_compte_rendu["date"] . "<br>Elément : " . $row_compte_rendu["description"] . "</li>";
            }
            echo "</ul>";
        } else {
            echo "Aucun compte rendu trouvé pour cet utilisateur.";
        }
    } else {
        echo "L'identifiant de l'utilisateur n'est pas valide.";
    }
  echo "<form method='post' action='deco.php'><button type='submit' name='deco'>Déconnexion</button></form>";
   
    ?>
    </div>
    <div class="nes-container">
    <h1>Supprimer utilisateur</h1>
    <form method="post" action="">
    <!-- Utilisez une balise input de type hidden pour stocker la valeur de $destinataire -->
    <input type="hidden" name="destinataire" value="<?php echo $destinataire; ?>">

    <!-- Bouton de soumission du formulaire -->
    <button type="submit" name="btnsup">Supprimer</button>
<?php
// Vérifiez si le bouton est cliqué
if (isset($_POST['btnsup'])) {
    // Récupérez la valeur de $destinataire depuis le formulaire
    $destinataire = $_POST['destinataire'];
   

    // Exécutez votre requête de suppression ici
    $SQLsupr = "DELETE FROM UTILISATEUR WHERE num='$destinataire'";
    echo $SQLsupr; // Affichez la requête pour débogage

    if ($conn->query($SQLsupr)) {
        // La requête s'est exécutée avec succès
        echo "Utilisateur supprimé avec succès!";
    } else {
        // Affichez l'erreur s'il y en a une
        echo "Erreur lors de la suppression : " . mysqli_error($conn);
    }
}
?>


</form>
</body>
</html>




