package HubertRoszyk.company;

import net.maritimecloud.internal.core.javax.json.Json;
import net.maritimecloud.internal.core.javax.json.JsonObject;
import net.maritimecloud.internal.core.javax.json.JsonReader;
import net.maritimecloud.internal.core.javax.json.JsonReaderFactory;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Scanner;

public class GetUserData {
    ListManager listManager = ListManager.getInstance();
    public User getUserFromDatabase() {
        return new User(1, "n", 0, 0);
    }
    public static User creatingNewUser() throws IOException {
        URL url = new URL("https://late-waterfall-81813.pktriot.net/Game/User.json");
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
    }
    public User creatingNewUserTerminal(){
        System.out.println("Wpisz Nazwę i hasło");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String passwort = scanner.next();

        return new User(listManager.users.size() + 1, name, 0, 0);
    }
}
