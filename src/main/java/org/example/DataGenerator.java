package org.example;

import com.github.javafaker.Faker;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.concurrent.TimeUnit;

public class DataGenerator {
    public static void main(String[] args) {
        try (com.mongodb.client.MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("myDatabase");
            MongoCollection<Document> collection = database.getCollection("users");

            Faker faker = new Faker();
            for (int i = 0; i < 100; i++) {
                Document user = new Document("name", faker.name().fullName())
                        .append("age", faker.number().numberBetween(20, 50))
                        .append("email", faker.internet().emailAddress())
                        .append("createdAt", faker.date().past(1000, TimeUnit.DAYS));
                collection.insertOne(user);
            }
            System.out.println("Inserted 100 fake users.");
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}