package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomMenusMaker {
    public static void findMenu(List<String> coachNames, List<String> randomCategories) {
        for (String coachName : coachNames) {
            Coach coach = CoachRepository.findCoachByName(coachName);

            Set<String> alreadyEat = new HashSet<>();
            List<String> randomMenus = takeRandomMenus(coach.getNotEatFoods(), randomCategories, alreadyEat);

            RecommendationMenu recommendationMenu = new RecommendationMenu(coachName, randomMenus);

            RecommendationMenuRepository.addRecommendationMenu(recommendationMenu);
        }
    }

    public static List<String> takeRandomMenus(List<String> notEatFood, List<String> randomCategories, Set<String> alreadyEat) {
        List<String> randomMenus = new ArrayList<>();
        for (String randomCategory : randomCategories) {
            Category category = CategoryRepository.findCategoryByCategoryName(randomCategory);
            List<String> categoryFoods = category.getFoods();

            String randomMenu = makeRandomMenu(categoryFoods, notEatFood, alreadyEat);
            randomMenus.add(randomMenu);
            alreadyEat.add(randomMenu);
        }
        return randomMenus;
    }

    public static String makeRandomMenu(List<String> categoryFoods, List<String> notEatFood, Set<String> alreadyEat) {
        String randomMenu;

        while (true) {
            randomMenu = Randoms.shuffle(categoryFoods).get(0);

            if (!alreadyEat.contains(randomMenu) && !notEatFood.contains(randomMenu)) {
                break;
            }
        }
        return randomMenu;
    }
}
