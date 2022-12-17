package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.validation.CategoryValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private Map<Integer, Category> categories;
    private List<Category> weekCategories;

    public Menu() {
        categories = new HashMap<>();
        weekCategories = new ArrayList<>();
        init();
    }

    public void init() {
        addCategories();
    }

    public List<Category> getWeekCategories() {
        return weekCategories;
    }

    private void addCategories() {
        categories.put(1,Category.JAPAN);
        categories.put(2,Category.KOREA);
        categories.put(3,Category.CHINA);
        categories.put(4,Category.ASIA);
        categories.put(5,Category.WESTERN);
    }

    public void makeWeekCategories() {
        while (weekCategories.size() != 5) {
            generateRandomCategory();
        }
    }

    private void generateRandomCategory() {
        Category category = categories.get(Randoms.pickNumberInRange(1, 5));
        if (CategoryValidation.checkWeekCategoryValid(category, weekCategories)) {
            weekCategories.add(category);
        }
    }


}
