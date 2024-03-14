package com.myApi.Example;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myApi.Model.UserModel;

@RestController
public class ExampleController {
    @GetMapping("/example")
    public String hello(){
        return "Hello, there!";
    }

    @PostMapping("/example")
    public String action(@RequestBody Map<String, Object> data){
        System.out.println(data.get("email"));
        UserModel user = new UserModel();
        user.SetUser(data.get("email").toString(), data.get("username").toString(), data.get("password").toString());
        user.Upload();
        System.out.println(user.GetEmail());

        return "Form succesfully submitted!";
    }
}
