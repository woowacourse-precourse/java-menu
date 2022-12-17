package menu;

import menu.domain.Coach;
import menu.domain.MenuRecommender;
import menu.domain.RandomCategoryGenerator;
import menu.enums.Category;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        CoachRepository coachRepository = new CoachRepository();
        MenuRecommender menuRecommender = new MenuRecommender(coachRepository);
//        menuRecommender.run();

//        System.out.println(Category.ASIAN.getMenus());

        Coach coach = new Coach("hanuel", Arrays.asList("밥", "빵"));
        System.out.println(menuRecommender.validateMenu("빵", coach));
    }
}
