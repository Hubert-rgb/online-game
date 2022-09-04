package HubertRoszyk.company.controller;

import HubertRoszyk.company.entiti_class.User;
import HubertRoszyk.company.service.UserService;
import HubertRoszyk.company.wrongDataException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @PostMapping("/loginUser")
    public User loginUser(@RequestBody JSONObject jsonInput) {
        String name = (String) jsonInput.get("name");
        String password = (String) jsonInput.get("password");


        User currentUser;

        List<User> users = userService.getUsersList();

        for (User user : users) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                currentUser = user;
                return currentUser;
            } else if (user.getName().equals(name)) {
                throw new wrongDataException();
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
