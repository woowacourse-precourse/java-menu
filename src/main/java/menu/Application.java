package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Category category = new Category();
        for (String item : category.choose()) {
            System.out.print(item + " ");
        }
        System.out.println();

        Coach coach = new Coach();
        Map<String, List<String>> coaches = new HashMap<>();
        while (true) {
            try {
                List<String> names = coach.getNames();
                for (String name : names) {
                    coaches.put(name, coach.getHates(name));
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
        System.out.println();
    }
}
