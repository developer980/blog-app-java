package com.myApi.Model;
import com.myApi.Services.BlogService;
import java.util.List;

import org.bson.Document;
import org.springframework.http.ResponseEntity;

public class BlogModel {
    private String title;
    private String author;
    private String textContent;
    private BlogService blogService = new BlogService();

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getTextContent(){
        return this.textContent;
    }

    public void setTextContent(String textContent){
        this.textContent = textContent;
    }

    public void Post(){
        blogService.Postblog(this.title, this.textContent, "Tudor");
    }

    public List<Document> GetBlogs(){
        return blogService.GetBlogs(this.title, this.textContent, "Tudor");
    }
}
