package menu.controller;

import menu.model.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RecommenderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryRecommender categoryRecommender;
    private final MenuRecommender menuRecommender;
    private final int NUMBER_OF_RECOMMEND = 5;

    private List<Category> recommendedCategories = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();

    public RecommenderController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.categoryRecommender = new CategoryRecommender();
        this.menuRecommender = new MenuRecommender();
    }

    public void run() {
        outputView.showStartRecommender();
        registerCoaches();
        registerDislikeMenu();
        makeRecommendedCategories();
        recommendMenuToCoach();
        
    }

    private void registerCoaches() {
        List<String> coachesName = getValidCoachesName();
        for (String name : coachesName) {
            coaches.add(new Coach(name));
        }
    }

    private List<String> getValidCoachesName() {
        List<String> coachesName = new ArrayList<>();
        while (coachesName.size() == 0) {
            try {
                String userInput = inputView.getCoachesName();
                coachesName = Validator.isValidCoachesName(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return coachesName;
    }

    private void registerDislikeMenu() {
        for (Coach coach : coaches) {
            List<String> dislikeMenu = getValidDislikeMenus(coach.getName());
            coach.registerDislikeMenu(dislikeMenu);
        }
    }

    private List<String> getValidDislikeMenus(String coachName) {
        List<String> dislikeMenus = null;
        while (dislikeMenus == null) {
            try {
                String userInput = inputView.getDislikeMenus(coachName);
                dislikeMenus = Validator.isValidDislikeMenus(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return dislikeMenus;
    }

    private void makeRecommendedCategories() {
        for (int count = 0; count < NUMBER_OF_RECOMMEND; count++) {
            recommendValidCategory();
        }
    }

    private void recommendValidCategory() {
        Category recommendedCategory;
        do {
            recommendedCategory = categoryRecommender.recommendCategory();
        }
        while (!Validator.isValidCategory(recommendedCategory, recommendedCategories));
        recommendedCategories.add(recommendedCategory);
    }

    private void recommendMenuToCoach() {
        for (Coach coach : coaches) {
            recommendValidMenu(coach);
        }
    }

    private void recommendValidMenu(Coach coach) {
        for (Category category : recommendedCategories) {
            String menu;
            do {
                menu = menuRecommender.recommendMenu(category);
            }
            while (!(coach.canEatMenu(menu) && !coach.isDuplicateMenu(menu)));
            coach.getRecommendedMenu(menu);
        }
    }
}
