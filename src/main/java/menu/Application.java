package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Category category = new Category();
        List<String> categories = category.choose();
        for (String item : categories) {
            System.out.print(item + " ");
        }
        System.out.println();

        Coach coach = new Coach();
        Map<String, List<String>> coaches = new HashMap<>();
        List<String> names = coach.getNames();
        for (String name : names) {
            coaches.put(name, coach.getHates(name));
        }

        Menu menu = new Menu();
        for (String name : names) {
            for (String item : menu.recommend(categories, coaches.get(name))) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
