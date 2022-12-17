package menu.domain;

import menu.enums.Category;
import menu.repository.CategoryRepository;
import menu.repository.CoachRepository;

public class MenuRecommender {
    private CoachRepository coachRepository = new CoachRepository();
    private CategoryRepository categoryRepository = new CategoryRepository();
    private RandomCategoryGenerator randomCategoryGenerator = new RandomCategoryGenerator();

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

            cnt++;
        }
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
