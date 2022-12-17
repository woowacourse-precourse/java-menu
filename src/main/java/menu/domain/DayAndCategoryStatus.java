package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static menu.constants.CategoryAndMenuDefinition.japaneseFood;
import static menu.constants.CategoryAndMenuDefinition.koreanFood;
import static menu.constants.CategoryAndMenuDefinition.chineseFood;
import static menu.constants.CategoryAndMenuDefinition.asian;
import static menu.constants.CategoryAndMenuDefinition.westernCuisine;

public class DayAndCategoryStatus {
    public List<String> randomCategory() {
        List<Integer> categories = randomNumericalStage();

        List<String> saveDayCategory = dayCategory(categories);

        HashMap<String, List<String>> countryMenu = createComparisonMap();

        List<String> randomFood = randomFoods(saveDayCategory, countryMenu);

        return randomFood;
    }

    private static List<String> randomFoods(List<String> saveDayCategory, HashMap<String, List<String>> countryMenu) {
        List<String> randomFood = new ArrayList<>();
        for (String day : saveDayCategory) {

            List<String> foods = countryMenu.get(day);
            String menu = Randoms.shuffle(foods).get(0);
            randomFood.add(menu);
        }
        return randomFood;
    }

    private static HashMap<String, List<String>> createComparisonMap() {
        HashMap<String, List<String>> countryMenu = new HashMap<>();
        countryMenu.put("1", japaneseFood);
        countryMenu.put("2", koreanFood);
        countryMenu.put("3", chineseFood);
        countryMenu.put("4", asian);
        countryMenu.put("5", westernCuisine);
        return countryMenu;
    }

    private static List<String> dayCategory(List<Integer> categories) {
        List<String> saveDayCategory = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String category = String.valueOf(categories.get(Randoms.pickNumberInRange(1, 5)));
            saveDayCategory.add(category);
        }
        return saveDayCategory;
    }

    private static List<Integer> randomNumericalStage() {
        List<Integer> categories = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            categories.add(i);
        }
        return categories;
    }

}