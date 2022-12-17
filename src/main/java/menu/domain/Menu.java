package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.validation.CategoryValidation;

import java.util.*;

import static menu.constant.MenuConstant.*;

public class Menu {

    private Map<Integer, Category> categoryNames;
    private Map<Category,List<String>> categoryValues;
    private List<Category> weekCategories;

    public Menu() {
        categoryNames = new HashMap<>();
        categoryValues = new TreeMap<>();
        weekCategories = new ArrayList<>();
        init();
    }

    public void init() {
        addCategoryNames();
        addCategoryValues();
        makeWeekCategoryNames();
    }

    private void addCategoryNames() {
        categoryNames.put(1,Category.JAPAN);
        categoryNames.put(2,Category.KOREA);
        categoryNames.put(3,Category.CHINA);
        categoryNames.put(4,Category.ASIA);
        categoryNames.put(5,Category.WESTERN);
    }

    private void addCategoryValues() {
        List<Category> categories = Category.getList();
        for (Category category : categories) {
            categoryValues.put(category, generateCategoryMenu(category));
        }
    }

    public void makeWeekCategoryNames() {
        while (weekCategories.size() != 5) {
            generateRandomCategory();
        }
    }

    private void generateRandomCategory() {
        Category category = categoryNames.get(Randoms.pickNumberInRange(1, 5));
        if (CategoryValidation.checkWeekCategoryValid(category, weekCategories)) {
            weekCategories.add(category);
        }
    }

    private List<String> generateCategoryMenu(Category category) {
        if (category == Category.JAPAN) {
            return Arrays.asList(MENU_JAPAN.split(","));
        }
        if (category == Category.KOREA) {
            return Arrays.asList(MENU_KOREA.split(","));
        }
        if (category == Category.CHINA) {
            return Arrays.asList(MENU_CHINA.split(","));
        }
        if (category == Category.ASIA) {
            return Arrays.asList(MENU_ASIA.split(","));
        }
        return Arrays.asList(MENU_WESTERN.split(","));
    }


}
