package menu.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommender {
    private static final int DAYS_OF_A_WEEK = 5;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 5;

    private final List<Category> categories = new ArrayList<>(DAYS_OF_A_WEEK);

    public Recommender() {
        recommendCategories();
    }

    private void recommendCategories() {
        for (int i = 1; i <= DAYS_OF_A_WEEK; i++) {
            int randomNumber = pickNumberInRange(MIN_RANGE, MAX_RANGE);
            Category category = Category.of(randomNumber);

            if (countCategory(category) >= 2) {
                i--;
                continue;
            }

            this.categories.add(category);
        }
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    private int countCategory(Category targetCategory) {
        int count = 0;
        for (Category category : categories) {
            if (category.equals(targetCategory)) {
                count++;
            }
        }
        return count;
    }

    public void recommendMenus(List<Coach> coaches) {
        for (int i = 0; i < categories.size(); i++) {
            Category dailyCategory = categories.get(i);

            for (Coach coach : coaches) {
                String randomMenuByCategory = Menu.getRandomMenuByCategory(dailyCategory);
                coach.setRecommendedMenus(randomMenuByCategory);
            }
        }
    }
}
