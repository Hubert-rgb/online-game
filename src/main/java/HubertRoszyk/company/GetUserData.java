package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")
@RestController
public class GetUserData {
    private final static ListManager listManager = ListManager.getInstance();


    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestParam String name, String password) {
        User currentUser = null;
        for (User user : listManager.users) {
            if(user.getName().equals(name) && user.getPassword().equals(password)) {
                currentUser = user;

            }
        }
        if (currentUser == null) {
            currentUser = createUser(name, password);
        }

        return ResponseEntity.ok()
                //.header("Access-Control-Allow-Credentials", "true")
                .body(                "{\"id\":\"" + currentUser.getId() + "\",\"name\":\"" + currentUser.getName() + "\",\"password\":\"" + currentUser.getPassword() + /*"\",\"industryPoints\":\"" +
                currentUser.getIndustryPoints() + "\",\"sciencePoints\":\"" + currentUser.getSciencePoints() + */ "\"}");
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
