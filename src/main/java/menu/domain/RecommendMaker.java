package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.generator.CategoryGenerator;

import java.util.List;

public class RecommendMaker {

    private final CategoryGenerator categoryGenerator;

    public RecommendMaker(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public void recommend() {
        for (int i = 0; i < 5; i++) {
            Category category = recommendCategory();
            CoachRepository.getCoaches()
                    .forEach(coach -> recommendMenu(category, coach));
        }
    }

    private void recommendEachCoach(Coach coach, Category category) {
        recommendMenu(category, coach);
    }

    private Category recommendCategory() {
        Category category;
        do {
            category = categoryGenerator.generate();
        } while (!CoachRepository.checkTooManySameCategory(category));
        CoachRepository.addCategory(category);
        return category;
    }

    private void recommendMenu(Category category, Coach coach) {
        List<String> menuNames = MenuRepository.getCategoryMenus(category);
        Menu menu;
        do {
            String menuName = Randoms.shuffle(menuNames).get(0);
            menu = MenuRepository.findByName(menuName);
        } while (!coach.checkValidMenu(menu));
        coach.addRecommendMenu(menu);
    }
}
