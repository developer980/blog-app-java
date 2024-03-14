package com.myApi.Services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseService {
    private static Dotenv dotenv = Dotenv.load();
    private static String URI = dotenv.get("DB_URI");
    private static String DB_NAME = dotenv.get("DB_NAME");

    public static MongoDatabase getConnection(){
        System.out.println("URIII" + URI);
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DB_NAME);
    }
}
