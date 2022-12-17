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
            Category category = randomCategoryGenerator.create();
            if(!validateCategory(category)){
                continue;
            }
            categoryRepository.save(category);
            cnt++;
        }
    }

    private boolean validateCategory(Category category) {
        if (categoryRepository.countByCategory(category) >= 2) {
            return false;
        }
        return true;
    }
}
