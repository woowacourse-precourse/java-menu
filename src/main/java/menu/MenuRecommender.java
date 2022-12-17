package menu;

import utils.RandomCategoryGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommender {
    private static final String DELIMITER = ",";
    private static final List<Coach> coaches = new ArrayList<>();

    public static List<String> splitter(String coachNames) {
        return Arrays.stream(coachNames.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static Coach creatorCoach(String coachName, String hateFoods) {
        List<String> foods = splitter(hateFoods);

        Coach coach = new Coach(coachName, foods);

        coaches.add(coach);

        return coach;
    }

    public static void getCoachRecommendFoods() {
        for (Coach coach : coaches) {
            getEachCoachRecommendFoods(coach);
            System.out.println(coach);
        }
    }

    private static void getEachCoachRecommendFoods(Coach coach) {
        List<String> categories = getRandomCategories(coach);
        coach.setCategories(categories);
    }

    private static List<String> getRandomCategories(Coach coach) {
        List<String> categories = new ArrayList<>();

        for (int i = 0 ; i < 5 ; i++) {
            String category = RandomCategoryGenerator.getRandomCategory();
            if (coach.isValidCategory(category)) {
                categories.add(category);
            }
        }

        return categories;
    }
}
