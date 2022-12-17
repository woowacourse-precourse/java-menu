package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendation {
    private static final int RECOMMEND_SIZE = 5;

    List<Category> randomCategories = new ArrayList<>();
    List<String> randomMenus = new ArrayList<>();

    public List<Category> getRandomCategories() {
        Category[] categories = Category.values();

        while (randomCategories.size() < RECOMMEND_SIZE) {
            int number = Randoms.pickNumberInRange(1, 5);
            Category category = categories[number - 1];

            if (isValidCategory(category))
                randomCategories.add(category);
        }
        return randomCategories;
    }

    public List<String> getRandomMenus(Coach coach) {
        clearMenus();

        while (randomMenus.size() < RECOMMEND_SIZE) {
            Category category = randomCategories.get(randomMenus.size());

            List<String> menus = category.getMenu().getMenus();
            int index = Randoms.pickNumberInRange(0, menus.size() - 1);
            String randomMenu = menus.get(index);
            if (!hasMenu(randomMenu) && !coach.isUnwantedMenu(randomMenu))
                randomMenus.add(randomMenu);
        }
        return randomMenus;
    }

    private boolean hasMenu(String randomMenu) {
        return randomMenus.contains(randomMenu);
    }

    private void clearMenus() {
        randomMenus.clear();
    }

    private boolean isValidCategory(Category category) {
        long numberOfCategory = randomCategories.stream()
                .filter(s -> s.equals(category))
                .count();
        if (numberOfCategory >= 2)
            return false;

        return true;
    }
}
