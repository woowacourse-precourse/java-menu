package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Coach;
import menu.utls.Validator;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MenuController {
    private static final String DELIMITER = ",";

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
    }

    private List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        HashMap<String, Integer> categoryCheck = new HashMap<>();
        addCategory(categories, categoryCheck);
        return categories;
    }

    private void addCategory(List<Category> categories, HashMap<String, Integer> categoryCheck) {
        //TODO 숫자 상수 분리
        int day = 0;
        while (day < 5) {
            Category category = Category.getCategoryByRandomNumber(Randoms.pickNumberInRange(1, 5));
            String categoryName = category.getName();
            if (!categoryCheck.containsKey(categoryName) || categoryCheck.get(categoryName) < 2) {
                categoryCheck.put(categoryName, categoryCheck.getOrDefault(categoryName, 0) + 1);
                categories.add(category);
                day++;
            }
        }
    }

    private void addAllegeMenu(List<Coach> coaches) {
        for (int index = 0; index < coaches.size(); index++) {
            Coach coach = coaches.get(index);
            String name = coach.getName();
            String[] allegeMenus = inputAllegeMenu(name, index).split(DELIMITER);
            for (String allegeMenu : allegeMenus) {
                coach.addAllergy(allegeMenu);
            }
        }
    }

    private String inputAllegeMenu(String name, int index) {
        try {
            String input = inputView.inputAllegeMenu(name);
            validator.validateAllegeMenu(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputAllegeMenu(name, index);
        }
    }

    private List<Coach> getCoaches() {
        String input = inputCoachNames();
        String[] coachNames = input.split(DELIMITER);
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName, new HashSet<>()));
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
