package menu.domain;

import menu.enums.Category;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

import java.util.List;

public class MenuRecommender {
    private final CoachRepository coachRepository;
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final RandomCategoryGenerator randomCategoryGenerator = new RandomCategoryGenerator();

    private final RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();
    public MenuRecommender(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public void run() {
        int cnt = 0;
        while (cnt < 5) {
            // 카테고리 정하기
            Category category = selectCategory();
            System.out.println(category);
            // 각 코치가 먹을 메뉴 추천
            List<Coach> coaches = coachRepository.getCoaches();
            for (Coach coach : coaches) {
                String menu = selectMenu(coach, category);
                System.out.println(menu);
            }
            cnt++;
        }
    }

    private String selectMenu(Coach coach, Category category) {
        String menu = randomMenuGenerator.create(category);
        if(!validateMenu(menu, coach)) {
            return selectMenu(coach, category);
        }
        return "";
    }

    public boolean validateMenu(String menu, Coach coach) {
        // 각 코치가 못 먹는 메뉴인지 확인
        if (!coach.canEat(menu)) {
            return false;
        }

        // 각 코치에게 이미 추천한 메뉴인지 확인
        if (coach.isRecommended(menu)) {
            return false;
        }
        return true;
    }

    public Category selectCategory() {
        Category category = randomCategoryGenerator.create();
        if(!validateCategory(category)){
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
