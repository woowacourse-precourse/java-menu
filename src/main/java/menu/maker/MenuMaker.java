package menu.maker;

import camp.nextstep.edu.missionutils.Randoms;
import menu.global.Constants;
import menu.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuMaker {

    public Map<String, List<String>> addMenu(final Category category,
                                             final List<String> coachNames,
                                             final Map<String, List<String>> exceptedFoods) {

        Map<String, List<String>> recommendMenuMap = initialMap(coachNames);

        for (int i = 1; i < category.getCategories().size(); i++) {
            String candidateCategory = category.getCategories().get(i);

            for (String coachName : coachNames) {
                List<String> exceptedFood = exceptedFoods.get(coachName);
                List<String> categories = Constants.MENU.get(candidateCategory);

                recommendMenu(recommendMenuMap, categories, exceptedFood, coachName);
            }
        }

        return recommendMenuMap;
    }

    private Map<String, List<String>> initialMap(final List<String> coachNames) {
        Map<String, List<String>> recommendMenuMap = new HashMap<>();

        for (String coachName : coachNames) {
            recommendMenuMap.put(coachName, new ArrayList<>());
        }

        return recommendMenuMap;
    }

    private void recommendMenu(final Map<String, List<String>> recommendMenuMap,
                               final List<String> categories,
                               final List<String> exceptedFoods,
                               final String coachName) {

        while (true) {
            String recommendedMenu = Randoms.shuffle(categories).get(0);

            if (containsExceptedFood(recommendedMenu, exceptedFoods) ||
                    isDuplicatedMenu(recommendedMenu, recommendMenuMap, coachName)) {
                continue;
            }

            recommendMenuMap.get(coachName).add(recommendedMenu);
            break;
        }
    }

    private boolean containsExceptedFood(final String menu, final List<String> exceptedFood) {
        return exceptedFood != null && exceptedFood.contains(menu);
    }

    private boolean isDuplicatedMenu(final String menu,
                                     final Map<String, List<String>> menus,
                                     final String coachName) {
        return menus.get(coachName).contains(menu);
    }

}
