package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.dto.RecommendationDTO;
import menu.model.Category;
import menu.model.Coach;
import menu.utils.Validator;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private static final String DELIMITER = ",";
    private static final int DAY_LENGTH = 5;
    private static final int CATEGORY_START_INCLUSIVE = 1;
    private static final int CATEGORY_END_INCLUSIVE = 5;
    private static final int CATEGORY_LIMIT = 2;

    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public MenuController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
    }

    public void run() {
        outputView.outputStartNotice();
        List<Coach> coaches = getCoaches();
        addAllegeMenu(coaches);
        List<Category> categories = getCategories();
        recommendMenu(coaches, categories);
        outputView.outputRecommendation(createRecommendationDTO(coaches, categories));
    }

    private RecommendationDTO createRecommendationDTO(List<Coach> coaches, List<Category> categories) {
        return new RecommendationDTO(getDTOCategories(categories),
                getDTOCoaches(coaches),
                getDTORecommendedMenus(coaches));
    }

    private List<List<String>> getDTORecommendedMenus(List<Coach> coaches) {
        List<List<String>> recommendedMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            recommendedMenus.add(coach.getRecommendation());
        }
        return recommendedMenus;
    }

    private List<String> getDTOCoaches(List<Coach> coaches) {
        return coaches.stream().map(Coach::getName).collect(Collectors.toList());
    }

    private List<String> getDTOCategories(List<Category> categories) {
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    private void recommendMenu(List<Coach> coaches, List<Category> categories) {
        for (int day = 0; day < DAY_LENGTH; day++) {
            for (Coach coach : coaches) {
                addRecommendation(categories, day, coach);
            }
        }
    }

    private void addRecommendation(List<Category> categories, int day, Coach coach) {
        while (true) {
            String menuName = getFirstMenu(categories.get(day));
            if (canRecommend(coach, menuName)) {
                coach.addRecommendation(menuName);
                break;
            }
        }
    }

    private boolean canRecommend(Coach coach, String menuName) {
        return !coach.checkExistedMenu(menuName) && !coach.checkAllegeMenu(menuName);
    }

    private String getFirstMenu(Category category) {
        return Randoms.shuffle(Category.getMenusByCategory(category.getName())).get(0);
    }

    private List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        HashMap<String, Integer> categoryCheck = new HashMap<>();
        addCategory(categories, categoryCheck);
        return categories;
    }

    private void addCategory(List<Category> categories, HashMap<String, Integer> categoryCheck) {
        int day = 0;
        while (day < DAY_LENGTH) {
            Category category = Category.getCategoryByRandomNumber(getCategoryRandomNumber());
            String categoryName = category.getName();
            if (canAddCategory(categoryCheck, categoryName)) {
                categoryCheck.put(categoryName, categoryCheck.getOrDefault(categoryName, 0) + 1);
                categories.add(category);
                day++;
            }
        }
    }

    private boolean canAddCategory(HashMap<String, Integer> categoryCheck, String categoryName) {
        return !categoryCheck.containsKey(categoryName) || categoryCheck.get(categoryName) < CATEGORY_LIMIT;
    }

    private int getCategoryRandomNumber() {
        return Randoms.pickNumberInRange(CATEGORY_START_INCLUSIVE, CATEGORY_END_INCLUSIVE);
    }

    private void addAllegeMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            String name = coach.getName();
            String[] allegeMenus = inputAllegeMenu(name).split(DELIMITER);
            for (String allegeMenu : allegeMenus) {
                coach.addAllergy(allegeMenu);
            }
        }
    }

    private String inputAllegeMenu(String name) {
        try {
            String input = inputView.inputAllegeMenu(name);
            validator.validateAllegeMenu(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputAllegeMenu(name);
        }
    }

    private List<Coach> getCoaches() {
        String input = inputCoachNames();
        String[] coachNames = input.split(DELIMITER);
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName, new HashSet<>(), new ArrayList<>()));
        }
        return coaches;
    }

    private String inputCoachNames() {
        try {
            String input = inputView.inputCoachNames();
            validator.validateCoachNames(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCoachNames();
        }
    }
}
