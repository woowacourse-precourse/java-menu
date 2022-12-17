package menu.controller;

import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuController {
    private Map<String, List<String>> categoriesAndMenu;
    private List<String> coachName;
    private Map<String, List<String>> coachDislikeFood;
    private Map<String, List<String>> foodRecommendedByCoaches = new HashMap<>();
    private List<String> pickedCategories = new ArrayList<>();

    private Menu menu;
    private InputView inputView;
    private OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menu = new Menu();
        this.categoriesAndMenu = menu.getMenu();
    }

    private void setCoachName() {
        outputView.printInputCoachNameMessage();
        coachName = inputView.readCoachName();
    }

    private void setCoachDislikeFood() {
        coachDislikeFood = inputView.readCoachDislikeFood(coachName);
    }

    public String pickTodayRandomCategory() {
        List<String> categories = categoriesAndMenu.keySet().stream().collect(Collectors.toList());
        String category = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
        try {
            checkDuplicateCategories(category);
        } catch (IllegalArgumentException exception) {
            pickTodayRandomCategory();
        }
        return category;
    }

    public void checkDuplicateCategories(String pickedCategory) {
        int duplicateCount = 0;
        if (pickedCategories.size() == 0) {
            return;
        }
        for (String category : pickedCategories) {
            if (category.equals(pickedCategory)) {
                duplicateCount++;
            }
        }
        if (duplicateCount > 2) {
            throw new IllegalArgumentException("[ERROR] 한 주에 카테고리가 2번 보다 더 겹칠 수는 없습니다.");
        }
    }

    public String recommendRandomMenu(String name, String category) {
        List<String> selectableMenu = categoriesAndMenu.get(category);
        String selectedMenu = Randoms.shuffle(selectableMenu).get(0);
        try {
            validateRecommendationMenu(name, selectedMenu);
        } catch (IllegalArgumentException exception) {
            recommendRandomMenu(name, category);
        }
        return selectedMenu;
    }

    public void validateRecommendationMenu(String name, String menu) {
        if (coachDislikeFood.get(name).contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 코치가 싫어하는 음식입니다.");
        }
        if (foodRecommendedByCoaches.size() != 0) {
            if (foodRecommendedByCoaches.get(name).contains(menu)) {
                throw new IllegalArgumentException("[ERROR] 이미 코치가 이번주에 추천받은 음식입니다.");
            }
        }
    }

    public void startRandomRecommendation() {
        for (String name : coachName) {
            foodRecommendedByCoaches.put(name, new ArrayList<>());
        }
        for (int i = 0; i < 5; i++) {
            // i는 요일 월(0), 화(1), 수(2), 목(3), 금(4)
            String pickedCategory = pickTodayRandomCategory();
            for (String name : coachName) {
                String pickedMenu = recommendRandomMenu(name, pickedCategory);
                foodRecommendedByCoaches.get(name).add(i, pickedMenu);
            }
        }
    }

    public void startProgram() {
        MenuController menuController = new MenuController();
        menuController.setCoachName();
        menuController.setCoachDislikeFood();
        menuController.startRandomRecommendation();
        outputView.printFinalResult(foodRecommendedByCoaches);
    }
}
