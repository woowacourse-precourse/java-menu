package menu;

import utils.ConstValue;
import utils.RandomCategoryGenerator;
import utils.RandomMenuSelector;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRecommender {
    private static final int INITIAL_COUNT = 0;
    private static final int ADD_COUNT = 1;
    private static final int LIMIT_COUNT = 3;
    private static final int MAX_CATEGORY_COUNT = 5;

    private static final String DELIMITER = ",";

    private static final List<Coach> coaches = new ArrayList<>();
    private static List<String> categories;
    private static final Map<String, Integer> categoriesCounter = initCounter();

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

        for (Coach coach : coaches) {
            coach.setCategories(categories);
        }

        for (String category : categories) {
            getEachCategoryRecommend(category);
        }
    }

    public static void getEachCategoryRecommend(String category) {
        for (Coach coach : coaches) {
            String menu = getOneFood(category, coach);
            coach.addMenu(menu);
        }
    }

    private static String getOneFood(String category, Coach coach) {
        String menu;

        List<String> menuList = Menus.getMenusList(category);
        RandomMenuSelector randomMenuSelector = new RandomMenuSelector();

        do {
            menu = randomMenuSelector.getRandomMenu(menuList);
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
        return categories.size() != MAX_CATEGORY_COUNT;
    }

    public static boolean isValidCategory(String category) {
        if (categoriesCounter.get(category) + ADD_COUNT < LIMIT_COUNT) {
            categoriesCounter.put(category,categoriesCounter.getOrDefault(category, INITIAL_COUNT) + ADD_COUNT);
            return true;
        }

        return false;
    }

    private static Map<String, Integer> initCounter() {
        Map<String, Integer> counter = new HashMap<>();

        counter.put(Category.getCategories(ConstValue.ILLSIK), INITIAL_COUNT);
        counter.put(Category.getCategories(ConstValue.HANSIK), INITIAL_COUNT);
        counter.put(Category.getCategories(ConstValue.JOONGSIK), INITIAL_COUNT);
        counter.put(Category.getCategories(ConstValue.ASIAN), INITIAL_COUNT);
        counter.put(Category.getCategories(ConstValue.YANGSIK), INITIAL_COUNT);

        return counter;
    }

    public static String getResult() {
        StringBuilder result = new StringBuilder();
        result.append(combine(ConstValue.days)).append("\n");
        result.append("[ 카테고리 | ").append(String.join(" | ", categories)).append(" ]").append("\n");

        for (Coach coach : coaches) {
            result.append(coach.toString()).append("\n");
        }

        return result.toString();
    }

    public static String combine(List<String> contents) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(String.join(" | ", contents)).append(" ]");

        return sb.toString();
    }
}
