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
        CoachRepository.getCoaches()
                .forEach(this::recommendEachCoach);
    }

    private void recommendEachCoach(Coach coach) {
        while (!isRecommendFinished(coach)) {
            Category category = recommendCategory(coach);
            recommendMenu(category, coach);
        }
    }

    private boolean isRecommendFinished(Coach coach) {
        return coach.isRecommendFinish();
    }

    private Category recommendCategory(Coach coach) {
        Category category;
        do {
            category = categoryGenerator.generate();
        } while (!coach.checkTooManySameCategory(category));
        return category;
    }

    private void recommendMenu(Category category, Coach coach) {
        List<String> menuNames = MenuRepository.getCategoryMenus(category);
        Menu menu;
        do {
            String menuName = Randoms.shuffle(menuNames).get(0);
            menu = MenuRepository.findByName(menuName);
        } while (!coach.checkOverlappedMenu(menu));
    }
}
