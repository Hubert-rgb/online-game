package HubertRoszyk.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetUserData {
    ListManager listManager = ListManager.getInstance();
    public User getUserFromDatabase() {
        return new User(1, "n", 0, 0);
    }
    public User creatingNewUser() throws IOException {
        URL url = new URL(ConfigOperator.websiteLink);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        String userData;
        try {
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
        userData.split(";");

        //JSON operation
        String name = "n";
        String password = "p";
        return new User(listManager.users.size() + 1, name, 0, 0);
    }
    public User creatingNewUserTerminal(){
        System.out.println("Wpisz Nazwę i hasło");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String passwort = scanner.next();

        return new User(listManager.users.size() + 1, name, 0, 0);
    }
}
