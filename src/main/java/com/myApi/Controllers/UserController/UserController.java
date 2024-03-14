package com.myApi.Controllers.UserController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import com.myApi.Model.UserModel;

@RestController
public class UserController {
    @PostMapping("/register")

public void postUser(@RequestBody Map<Object, String> data){
        UserModel user = new UserModel();
        user.SetUser(data.get("email"),data.get("username"), data.get("password"));
        user.Upload();
    }
}
