package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")
@RestController
@Controller
public class UserController {
    @PostMapping("/loginUser")
    public User loginUser(@RequestBody JSONObject jsonInput) {
        String name = (String) jsonInput.get("name");
        String password = (String) jsonInput.get("password");


        User currentUser = null;

        List<User> users = userService.getUsersList();

        for (User user : users) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                currentUser = user;
                return currentUser;
            }
        }

        currentUser = createUser(name, password);
        return currentUser;
    }
    @Autowired
    private UserService userService;
    public User createUser(String name, String password) {
        User user = new User(name, password);

        userService.saveUser(user);
        return user;
    }
}
