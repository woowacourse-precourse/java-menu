package menu.domain;

import menu.enums.Category;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommender {
    private final CoachRepository coachRepository;
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final RandomCategoryGenerator randomCategoryGenerator = new RandomCategoryGenerator();

    private final RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();
    private final OutputView outputView = new OutputView();

    public MenuRecommender(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public void run() {
        int cnt = 0;
        while (cnt < 5) {
            Category category = selectCategory();

            List<Coach> coaches = coachRepository.getCoaches();
            for (Coach coach : coaches) {
                selectMenu(coach, category);
            }
            cnt++;
        }
        outputView.printResult(categoryRepository.categoryRecommendationResult(), coachRepository.menuRecommendationResult());
    }

    public String selectMenu(Coach coach, Category category) {
        String menu = randomMenuGenerator.create(category);
        if (!validateMenu(menu, coach)) {
            return selectMenu(coach, category);
        }
        coach.addRecommendedMenu(menu);
        return menu;
    }

    public boolean validateMenu(String menu, Coach coach) {
        if (!coach.canEat(menu)) {
            return false;
        }
        if (coach.isRecommended(menu)) {
            return false;
        }
        return true;
    }

    public Category selectCategory() {
        Category category = randomCategoryGenerator.create();
        if (!validateCategory(category)) {
            return selectCategory();
        }
        categoryRepository.save(category);
        return category;
    }

    private boolean validateCategory(Category category) {
        if (categoryRepository.countByCategory(category) >= 2) {
            return false;
        }
        return true;
    }
}
