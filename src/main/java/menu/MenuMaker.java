package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.MenuCandidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuMaker {

    public Map<String, List<String>> addMenu(Category category, List<String> coachNames,
                                             Map<String, List<String>> exceptedFoods) {
        Map<String, List<String>> recommendMenu = new HashMap<>();

        for (String coachName : coachNames) {
            recommendMenu.put(coachName, new ArrayList<>());
        }

        for (int i = 1; i < category.getCategories().size(); i++) {
            String candidateCategory = category.getCategories().get(i);

            for (String coachName : coachNames) {
                List<String> exceptedFood = exceptedFoods.get(coachName);
                List<String> categories = MenuCandidate.MENU.get(candidateCategory);

                while (true) {
                    String recommendedMenu = Randoms.shuffle(categories).get(0);

                    if (exceptedFood.contains(recommendedMenu) ||
                            recommendMenu.get(coachName).contains(recommendedMenu)) {
                        continue;
                    }

                    recommendMenu.get(coachName).add(recommendedMenu);
                    break;
                }
            }
        }

        return recommendMenu;
    }

}
