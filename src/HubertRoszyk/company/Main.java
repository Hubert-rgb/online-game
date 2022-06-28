package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListManager listManager = ListManager.getInstance();

        new GalaxyInit(8, 6);
        System.out.println(listManager.planets.get(0).size);
        System.out.println(listManager.planets.get(0).industryPointsMultiplier);
        System.out.println(listManager.planets.get(0).sciencePointsMultiplier);

        User user1 = new User(1, "Tynom", 0, 0);
        listManager.users.add(user1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        listManager.usersPlanetsHashMap.put(1, list);
        user1.getTotalIndustryIncome();
        System.out.print(listManager.usersPlanetsHashMap);
        PointGenerator.generatePoints();
    }
}
