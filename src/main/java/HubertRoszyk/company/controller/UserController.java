package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")
@RestController
@Controller
public class UserController {
    private final static ListManager listManager = ListManager.getInstance();


    @PostMapping("/loginUser")
    public User loginUser(@RequestParam String name, String password) {
        User currentUser = null;
        for (User user : listManager.users) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                currentUser = user;

            }
        }
        if (currentUser == null) {
            currentUser = createUser(name, password);
        }

        return currentUser;
    }
    @Autowired
    private UserService userService;
    public User createUser(String name, String password) {
        User user = new User(listManager.users.size() + 1, name, password);
        listManager.users.add(user);


        userService.saveUser(user);
        return user;
    }
}
