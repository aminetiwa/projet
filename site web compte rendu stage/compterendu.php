<?php
require('conf.php');
session_start();

// Vérifier si l'utilisateur est connecté
if (!isset($_SESSION['num_u'])) {
    // L'utilisateur n'est pas connecté, redirigez-le vers la page de connexion.
    header("Location: index.php");
    exit();
}

// Gestion de la soumission du formulaire de compte rendu
if (isset($_POST['update'])) {
    $date = $_POST['date'];
    $contenu = $_POST['contenu']; // Évitez d'utiliser addslashes, préférez les requêtes préparées
    $id_utilisateur = $_SESSION['num_u']; // Utilisation correcte de la session

    // Validation des données (ajoutez des vérifications supplémentaires si nécessaire)

    if (empty($date) || empty($contenu)) {
        echo "Veuillez remplir tous les champs.";
    } else {
        // Établir la connexion à la base de données
        $connexion = mysqli_connect($serveurBDD, $userBDD, $mdpBDD, $nomBDD);
        
        if (!$connexion) {
            die("Erreur de connexion à la base de données: " . mysqli_connect_error());
        }

        // Utilisation de requêtes préparées pour éviter les injections SQL
        $requete = "INSERT INTO CR (date, datetime, description, num_utilisateur) VALUES (?, NOW(), ?, ?)";
        
        // Préparation de la requête
        $stmt = mysqli_prepare($connexion, $requete);

        if ($stmt) {
            // Liaison des paramètres
            mysqli_stmt_bind_param($stmt, "sss", $date, $contenu, $id_utilisateur);
            
            // Exécution de la requête
            if (mysqli_stmt_execute($stmt)) {
                echo "Compte rendu inséré avec succès.";
            } else {
                echo "Erreur lors de l'insertion du compte rendu : " . mysqli_error($connexion);
            }

            // Fermeture de la requête préparée
            mysqli_stmt_close($stmt);
        } else {
            echo "Erreur lors de la préparation de la requête : " . mysqli_error($connexion);
        }

        // Fermeture de la connexion à la base de données
   
    }


// Vérifier si l'utilisateur existe (Vous pouvez ajouter cette vérification ici si nécessaire)
$requeteUtilisateur = "SELECT * FROM utilisateurs WHERE num = ?";
$stmtUtilisateur = mysqli_prepare($connexion, $requeteUtilisateur);

if ($stmtUtilisateur) {
    mysqli_stmt_bind_param($stmtUtilisateur, "s", $_SESSION['num_u']);
    if (mysqli_stmt_execute($stmtUtilisateur)) {
        $resultUtilisateur = mysqli_stmt_get_result($stmtUtilisateur);
        if (mysqli_num_rows($resultUtilisateur) > 0) {
            // L'utilisateur existe
        } else {
            // L'utilisateur n'existe pas
        }
    } else {
        echo "Erreur lors de la vérification de l'utilisateur : " . mysqli_error($connexion);
    }
    mysqli_stmt_close($stmtUtilisateur);
}}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Epopée-Légendaire des chevalier </title>
    <link rel="stylesheet" type="text/css" href="styles.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Press+Start+2P">
</head>
<body>
    <header>
        <h1>Stage Quest</h1>
 
    </header>
<nav>
    <a class="retro-button" href="Acueil.php">Sanctuaire</a>
    <a class="retro-button" href="profil.php">Profil</a>
    <a class="retro-button" href="compterendu.php">Epopée</a>
     

  

    </ul>


       
  
</nav>
<div class="nes-container">
    <h1>Mes Epopée-Légendaire </h1>
         <?php
        // Récupère les comptes rendus de l'utilisateur
        $sql_comptes_rendus = "SELECT date, description FROM CR WHERE num_utilisateur = '".$_SESSION['num_u']."'";
        $result_comptes_rendus = $conn->query($sql_comptes_rendus);

        if ($result_comptes_rendus->num_rows > 0) {
            while ($row_compte_rendu = $result_comptes_rendus->fetch_assoc()) {
                echo "<li>Epoque : " . $row_compte_rendu["date"] . "<br>Eléments : " . $row_compte_rendu["description"] . "</li>"."<br>";
            }
        } else {
            echo "Aucun compte rendu trouvé pour cet utilisateur.";
        }
    ?>
     <h1>Creer une Epopée Légendaire </h1>
    <!-- Formulaire de création de compte rendu -->
<form method="post" action="compterendu.php">
    <label for="date">Epoque :</label>
    <input class"retro-text" type="date" name="date" required><br>
    <label for="contenu">Eléments :</label>
    <textarea class="retro-input" name="contenu" rows="4" cols="40" required></textarea><br>
    <input type="hidden" name="id_utilisateur" value="<?php echo $_SESSION["num"]; ?>">
    <input class="retro-button" type="submit" name="update" value="Ajouter une Epopée-égendaire">

 
</form>
  <?php
     //verifie si le type est un prof ou eleve 
        //0 pour prof

    // Formulaire de déconnexion
    echo "<br><form method='post' action='deco.php'><button type='submit' name='deco'>Déconnexion</button></form>";
    ?>
</div>

</body>
</html>
