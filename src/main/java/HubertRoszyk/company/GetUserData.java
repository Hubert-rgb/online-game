package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.User;
import HubertRoszyk.company.database.DatabaseUserManager;
import org.apache.catalina.connector.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;


@RestController
public class GetUserData {

    private final static ListManager listManager = ListManager.getInstance();

    @PostMapping("/loginUser")
    public static String loginUser(@RequestParam String name, String password) throws ParseException { //jako form submit
        /*JSONParser parser = new JSONParser(); z jsona
        JSONObject jsonRequestBody = (JSONObject) parser.parse(userData);
        String name = (String) jsonRequestBody.get("name");
        String password = (String) jsonRequestBody.get("password");*/

        User currentUser = null;
        for (User user : listManager.users) {
            if(user.name.equals(name) && user.password.equals(password)) {
                currentUser = user;

            }
        }
        if (currentUser == null) {
            currentUser = createUser(name, password);
        }
        //JSONObject jsonResponseBody = new JSONObject(jsonResponseString);

        return "{\"id\":\"" + currentUser.id + "\",\"name\":\"" + currentUser.name + "\",\"password\":\"" + currentUser.password + "\",\"industryPoints\":\"" +
                currentUser.industryPoints + "\",\"sciencePoints\":\"" + currentUser.sciencePoints + "\"}"; //zwraca json
    }

    public static User createUser(String name, String password) {
        User user = new User(listManager.users.size() + 1, name, password, 0, 0);
        listManager.users.add(user);
        DatabaseUserManager.addUserToDatabase(user);

        GalaxyInit galaxyInit = new GalaxyInit();
        listManager.userGalaxy.put(user.id, listManager.galaxies.size());
        //System.out.println(listManager.galaxies.get(listManager.userGalaxy.get(user.id) - 1));
        return user;
    }

/*    public static User creatingNewUser() throws IOException {
        URL url = new URL("https://late-waterfall-81813.pktriot.net/Game/User.json"); //wysyła json, więc nie może to byc główna strona, ten co wysyła robi requesta
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        String userData;

        try {
            //JsonReaderFactory jsonReaderFactory = Json.createReaderFactory(Collections.emptyMap());
            //JsonReader jsonReader = jsonReaderFactory.createReader(new InputStreamReader(connection.getInputStream()));

            BufferedReader userDataReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inLine;
            StringBuilder stringBuilderUserData = new StringBuilder();


            while ((inLine = userDataReader.readLine()) != null) {
                stringBuilderUserData.append(inLine);
            }
            userData = stringBuilderUserData.toString();
        } finally {
            connection.disconnect();
        }
        System.out.println(userData);

        //JSON operation
        String name = "n";
        String password = "p";
        return new User(1, name, 0, 0);
    }*/
}
