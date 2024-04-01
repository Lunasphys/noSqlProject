package org.example;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoDBCrudOperations {
    public static void main(String[] args) {
        // Connexion à MongoDB
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("myDatabase");
            MongoCollection<Document> collection = database.getCollection("users");

            // Insertions données
            for (int i = 1; i <= 5; i++) {
                collection.insertOne(new Document("name", "User " + i)
                        .append("age", 25 + i)
                        .append("email", "user" + i + "@example.com")
                        .append("createdAt", new java.util.Date()));
            }
            System.out.println("Insertion des données terminée.");

            // Lis et affiche tous les utilisateurs de plus de 30 ans
            for (Document user : collection.find(Filters.gt("age", 30))) {
                System.out.println(user.toJson());
            }

            // Mets à jour l'âge de tous les utilisateurs en ajoutant 5 ans
            collection.updateMany(new Document(), Updates.inc("age", 5));
            System.out.println("Mise à jour de l'âge des utilisateurs terminée.");

            // Supprime un utilisateur
            collection.deleteOne(Filters.eq("name", "User 3"));
            System.out.println("Suppression de l'utilisateur spécifique terminée.");
        }
    }
}
