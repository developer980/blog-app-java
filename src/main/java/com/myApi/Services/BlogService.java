package com.myApi.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.http.ResponseEntity;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BlogService {
    MongoDatabase databaseConnection = DatabaseService.getConnection();
    MongoCollection <Document> collection = databaseConnection.getCollection("blog");

    public void Postblog(String title, String content, String author){
        Document document = new Document("title", title)
            .append("content", content)
            .append("author", author);

        collection.insertOne(document);
    }

    public List<Document> GetBlogs(String content, String title, String author){
        List<Document> blogList = new ArrayList<Document>();

        collection.aggregate(Arrays.asList(
            new Document("$match", new Document("content", java.util.regex.Pattern.compile(content))
                .append("title", java.util.regex.Pattern.compile(title))
                .append("author", java.util.regex.Pattern.compile(author))
            )
        )).forEach(blogList::add);
        
        System.out.println(blogList);
        return blogList;
    }
}
