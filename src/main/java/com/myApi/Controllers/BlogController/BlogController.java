package com.myApi.Controllers.BlogController;

import java.util.Map;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myApi.Model.BlogModel;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    BlogModel blog = new BlogModel();
    @PostMapping("/blog")
    public ResponseEntity<List<Document>> getBlog(@RequestBody Map<String, Object> data){

        blog.setTitle((String) data.get("title"));
        blog.setTextContent((String) data.get("content"));
        int currentLevel = (int) data.get("page");

        List<Document> blogs = blog.GetBlogs();
        // System.out.println("level" +  currentLevel + " " + blogs.size());

        if(blogs == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        if(currentLevel <  blogs.size()){
            return ResponseEntity.ok(blogPagination(blogs, currentLevel));
        }
        else{
            System.out.println("TOO MUCHH");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/upload-blog")
    public String postBlog(@RequestBody Map<String, Object> data){

        blog.setTitle((String) data.get("title"));
        blog.setTextContent((String) data.get("content"));
        blog.Post();

        return "Your blog was posted";
    }

    private List<Document> blogPagination(List<Document> blog, int currentLevel){
        List<Document> blogsPage = new ArrayList<Document>(5);

        if(currentLevel < blog.size()){
            for (int i = currentLevel; i < currentLevel + 5; i++){
                if(i < blog.size()){
                    blogsPage.add(blog.get(i));
                }
            }
        }
        
        System.out.println(blogsPage);

        return blogsPage;
    }
}
