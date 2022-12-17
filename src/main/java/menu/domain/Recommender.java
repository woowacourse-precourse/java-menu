package menu.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Recommender {
    private static final int DAYS_OF_A_WEEK = 5;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 4;

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

    private int countCategory(Category targetCategory) {
        int count = 0;
        for (Category category : categories) {
            if (category.equals(targetCategory)) {
                count++;
            }
        }
        return count;
    }

    public List<String> recommendMenus() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            String randomMenu = Menu.getRandomMenuByCategory(categories.get(i));

            if (result.contains(randomMenu)) {
                i--;
                continue;
            }

            result.add(randomMenu);
        }
        return result;
    }
}
