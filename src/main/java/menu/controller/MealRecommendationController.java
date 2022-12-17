package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MealRecommendationController {
    // 이거 리팩토링
    private final List<String> DAY_OF_WEEK = List.of("월요일", "화요일", "수요일", "목요일", "금요일");

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CoachRepository coachRepository;
    CategoryRepository categoryRepository;

    public MealRecommendationController() {
        this.coachRepository = CoachRepository.getInstance();
        this.categoryRepository = CategoryRepository.getInstance();
    }

    public void run() {
        outputView.printStartGuide();
        getAndSaveCoaches();
        getAndSaveEachCoachHateMenu();
        List<Category> thisWeekCategories = getThisWeekCategories();
    }


    private void getAndSaveCoaches() {
        outputView.printNameInputGuide();
        while (true) {
            try {
                List<String> coachNames = inputView.getCoachNames();
                saveCoaches(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void saveCoaches(List<String> names) {
        for (String name : names) {
            Coach coach = new Coach(name);
            coachRepository.save(coach);
        }
    }

    private void getAndSaveEachCoachHateMenu() {
        List<Coach> coaches = coachRepository.findAll();
        for (Coach coach : coaches) {
            outputView.printHateMenuInputGuide(coach.getName());
            List<String> hateMenusNames = inputView.getHateMenuNames();
            coach.setHateMenuNames(hateMenusNames);
        }
    }

    private List<Category> getThisWeekCategories() {
        List<Category> categories = new ArrayList<>();
        for (String DAY : DAY_OF_WEEK) {
            Category category = chooseCategory();
            categories.add(category);
        }
        return categories;
    }

    private Category chooseCategory() {
        Category category;
        do {
            category = categoryRepository.findById(Randoms.pickNumberInRange(1, 5));
        } while (category.isAlreadyRecommendedOver(2));

        category.updateRecommendedCount();
        return category;
    }
}

