package menu;

import utils.RandomCategoryGenerator;
import utils.RandomMenuSelector;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRecommender {
    private static final String DELIMITER = ",";
    private static final List<Coach> coaches = new ArrayList<>();
    private static List<String> categories;
    private static Map<String, Integer> categoriesCounter = initCounter();

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
        categories = getRandomCategories();
        System.out.println(categories);

        for (Coach coach : coaches) {
            coach.setCategories(categories);
            getEachCoachRecommend(coach);
            System.out.println(coach);
        }
    }

    private static void getEachCoachRecommend(Coach coach) {
        for (String category : categories) {
            String menu = getOneFood(category, coach);
            coach.addMenu(menu);
        }
    }

    private static String getOneFood(String category, Coach coach) {
        String menu;

        do {
            List<String> menuList = Menus.getMenusList(category);
            menu = RandomMenuSelector.getRandomMenu(menuList);
        } while (!isValidMenu(menu, coach));

        return menu;
    }

    private static boolean isValidMenu(String menu, Coach coach) {
        return !coach.isHate(menu);
    }

    private static List<String> getRandomCategories() {
        List<String> categories = new ArrayList<>();

        while (isCompleteCount(categories)) {
            String category = RandomCategoryGenerator.getRandomCategory();
            if (isValidCategory(category)) {
                categories.add(category);
            }
        }

        return categories;
    }

    private static boolean isCompleteCount(List<String> categories) {
        return categories.size() != 5;
    }

    public static boolean isValidCategory(String category) {
        if (categoriesCounter.get(category) + 1 < 3) {
            categoriesCounter.put(category,categoriesCounter.getOrDefault(category, 0) + 1);
            return true;
        }

        return false;
    }

    private static Map<String, Integer> initCounter() {
        Map<String, Integer> counter = new HashMap<>();

        counter.put(Category.getCategories(1), 0);
        counter.put(Category.getCategories(2), 0);
        counter.put(Category.getCategories(3), 0);
        counter.put(Category.getCategories(4), 0);
        counter.put(Category.getCategories(5), 0);

        return counter;
    }
}
