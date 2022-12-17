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
        Coach coach = new Coach("hanuel", Arrays.asList("규동", "우동", "미소시루", "가츠동", "오니기리", "하이라이스", "스시", "라멘"));
        coachRepository.save(coach);
        MenuRecommender menuRecommender = new MenuRecommender(coachRepository);
        menuRecommender.run();


//        String s = menuRecommender.selectMenu(coach, Category.JAPANESE);
//        System.out.println(s);


////        System.out.println(Category.ASIAN.getMenus());
//
//
//        System.out.println(menuRecommender.validateMenu("빵", coach));
    }
}
