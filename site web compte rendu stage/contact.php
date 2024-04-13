<!DOCTYPE html>

<!DOCTYPE html>
<html>
<head>
    <title>Guerrier</title>
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
    </ul>

    

</nav>
<div class="nes-container">
           

<html>
<head>
    <title>Registre des Chevaliers Tenebreux de l'informatique</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Registre des Chevaliers Tenebreux </h1>
    <ul>
        <?php
            require('conf.php');

            $bdd = "id20196766_projet_amine";
            
            // Connectez-vous à la base de données et récupérez la liste des utilisateurs

            if ($conn->connect_error) {
                die("Échec de la connexion à la base de données : " . $conn->connect_error);
            }

            $sql = "SELECT num, nom FROM UTILISATEUR";
            $result = $conn->query($sql);

            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    echo "<li><a href='msg.php?destinataire=" . $row["num"] . "'>" . $row["nom"] . "</a></li>";
                }
            }

            $conn->close();
        ?>
         <?php
   

    // Formulaire de déconnexion
    echo "<form method='post' action='deco.php'><button type='submit' name='deco'>Déconnexion</button></form>";
    ?>
    </ul>
</body>
</html>
</div>
 <footer>
        <p>&copy; 1990 Stage Quest. Le Gardien des récits.</p>
    </footer>
</body>
</html>

   
