package com.myApi.Services;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserService {
    MongoDatabase databaseConnection = DatabaseService.getConnection();
    MongoCollection <Document> collection = databaseConnection.getCollection("user");
    public void registerUser(String username, String email, String password){    
        Document document = new Document("email", email)
            .append("username", username)
            .append("password", password);

        collection.insertOne(document);
        System.out.println("Sending user with email " + email + " and username " + username + " to the database");
    }
}
