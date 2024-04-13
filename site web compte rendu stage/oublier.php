<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="styles.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
	<title>La Rennaissance Du Sceau</title>
	
</head>
<body>
    <header>
        <h1>Stage Quest</h1>
 
    </header>
<div class="nes-container">
    <h1>La Quête Du Sésame Perdu</h1>
   
<form method="POST">
	<label   for="mail">L'Enveloppe Electronique :</label>
	<input class="retro-input" type="text" name="mail" id="mail">
	<input class="retro-button"  type="submit" value="OK" name="btn_connexion">
	  <a href="index.php" class="contact-button">Le Pont Virtuel</a>
</form>

<?php
include 'conf.php';

// Vérification de la soumission du formulaire
if (isset($_POST["btn_connexion"])) {
    // Récupération de la valeur du champ email
    $mail = $_POST['mail'];

    if (empty($mail)) {
        echo "<p>Veuillez entrer une adresse e-mail.</p>";
        exit();
    }

    // Valider l'email
    if (filter_var($mail, FILTER_VALIDATE_EMAIL)) {
        // Recherche de l'adresse mail dans la base de données
        $sql = "SELECT * FROM UTILISATEUR WHERE email = '$mail'";
        $result = mysqli_query($conn, $sql);

        if ($result && mysqli_num_rows($result) > 0) {
            // L'adresse e-mail a été trouvée dans la base de données, générer un nouveau mot de passe aléatoire et l'envoyer par e-mail
            $nouveauMotDePasse = bin2hex(random_bytes(8));
            $from = "test@hostinger-tutorials.fr";
            $subject = "Réinitialisation de mot de passe";
            $message = "Votre nouveau mot de passe est : " . $nouveauMotDePasse;
            $headers = "From: " . $from;

          
                // Mettre à jour le mot de passe de l'utilisateur dans la base de données
                $mdp_hash = password_hash($nouveauMotDePasse, PASSWORD_DEFAULT);
                $sql_update = "UPDATE UTILISATEUR SET motdepasse='$mdp_hash' WHERE email='$mail'";
                mysqli_query($conn, $sql_update);
                if (mail($to, $subject, $message, $headers)) {

                // Affichage d'un message de confirmation
                echo "<p>Votre demande a bien été prise en compte. Vous allez recevoir un email pour réinitialiser votre mot de passe.</p>";
            } else {
                // En cas d'échec d'envoi d'email, affichage d'un message d'erreur
              
                // Ajoutez une ligne de journalisation pour enregistrer l'erreur
                error_log("Erreur d'envoi d'e-mail à l'adresse : $mail");
            }
        } else {
            // L'adresse e-mail n'a pas été trouvée dans la base de données
            echo "<p>Cet email n'existe pas dans notre base de données.</p>";
        }
    } else {
        // L'adresse e-mail n'est pas valide
        echo "<p>L'adresse e-mail n'est pas valide.</p>";
    }
        echo "E-mail envoyé avec succès. $nouveauMotDePasse";
      } else {
    echo "Échec de l'envoi de l'e-mail.";
}


mysqli_close($conn);
?>
</div>
 <footer>
        <p>&copy; 1990 Stage Quest. Le Gardien des récits.</p>
    </footer>
</body>
</html>
