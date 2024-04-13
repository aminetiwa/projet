<?php
$serveurBDD = "db5014738792.hosting-data.io"; // Adresse du serveur de base de données (généralement 'localhost' si la base de données est sur le même serveur que le script PHP)
$userBDD = "dbu2697288"; // Nom d'utilisateur de la base de données
$mdpBDD = "AP1_2024_Lapie"; // Mot de passe de la base de données
$nomBDD = "dbs12245403"; // Nom de la base de données à laquelle se connecter
// Connexion à la base de données MySQL
$conn = mysqli_connect($serveurBDD,$userBDD,$mdpBDD,$nomBDD);
// Vérifier la connexion
if(mysqli_connect_errno()) {
    die("ERREUR : Impossible de se connecter. " . mysqli_connect_error());
} else {
}

?>