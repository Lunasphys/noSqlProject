# noSqlProject
# Projet NoSQL avec MongoDB et Java

Ce projet implémente un système de génération de fausses données et de manipulation de données avec MongoDB. Il comprend également des scripts pour automatiser les opérations CRUD.

## Démarrage du Replica Set avec Docker

Pour démarrer le Replica Set avec Docker, exécutez la commande suivante à la racine du projet :

```bash
docker-compose up -d
```
Assurez-vous que Docker est installé sur votre machine avant d'exécuter cette commande.

## Génération et insertion de fausses données

Les fausses données sont générées à l'aide de la bibliothèque JavaFaker et insérées dans la collection users de la base de données MongoDB. Pour exécuter le script de génération de données, utilisez la commande suivante :

```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.DataGenerator"
```
## Commandes CLI pour les opérations CRUD

Les commandes CLI utilisées pour les opérations CRUD sont les suivantes :

Création (Insertion)
```bash
mongo
use myDatabase
db.users.insertMany([...])  // Remplacez [...] par les documents à insérer
```
Lecture (Trouver tous les utilisateurs de plus de 30 ans)

```
bash
mongo
use myDatabase
db.users.find({ age: { $gt: 30 } })
```
Mise à jour (Augmenter l'âge de tous les utilisateurs de 5 ans)
```
bash
mongo
use myDatabase
db.users.updateMany({}, { $inc: { age: 5 } })
```
Suppression (Supprimer un utilisateur spécifique)
```
bash
mongo
use myDatabase
db.users.deleteOne({ name: "NomUtilisateur" })  // Remplacez "NomUtilisateur" par le nom de l'utilisateur à supprimer
```
## Éxécution du script et différences observées

Le script Java DataGenerator exécute les mêmes opérations CRUD que celles effectuées via la CLI MongoDB, mais de manière automatisée. Certaines différences peuvent ressortir, comme des modifications de performance et de gestion des erreurs.

## Difficultés rencontrées et solutions

J'ai rencontré des difficultés lors de la configuration initiale du Replica Set avec Docker, et quelques erreurs aux démarrage de ces dernières. Ainsi qu'avec la configuration du fichier docker-compose.yml.
(Et aussi avec la configuration Java mais c'était plutôt une erreur de ma part lors de la création du projet Maven)