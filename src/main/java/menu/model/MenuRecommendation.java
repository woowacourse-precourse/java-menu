package menu.model;

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

    public String getRandomMenu(Coach coach, Category category) {
        List<String> menus = category.getMenu().getMenus();
        String randomMenu;
        while (true) {
            randomMenu = Randoms.shuffle(menus).get(0);
            if (coach.availableMenu(randomMenu))
                break;
        }

        return randomMenu;
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
