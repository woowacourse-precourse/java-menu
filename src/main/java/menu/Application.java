package menu;

import menu.domain.MenuRecommender;
import menu.domain.RandomCategoryGenerator;
import menu.enums.Category;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

public class Application {
    public static void main(String[] args) {
        CoachRepository coachRepository = new CoachRepository();
        MenuRecommender menuRecommender = new MenuRecommender(coachRepository);
        menuRecommender.run();
    }
}
