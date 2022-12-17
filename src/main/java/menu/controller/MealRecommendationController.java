package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.category.CategoryRepository;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachRepository;
import menu.domain.menu.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static menu.util.Constants.DAY_OF_WEEK;
import static menu.util.Constants.MAX_NUMBER_OF_DUPLICATE;

public class MealRecommendationController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CoachRepository coachRepository;
    CategoryRepository categoryRepository;
    MenuRepository menuRepository;

    public MealRecommendationController() {
        this.coachRepository = CoachRepository.getInstance();
        this.categoryRepository = CategoryRepository.getInstance();
        this.menuRepository = MenuRepository.getInstance();
    }

    public void run() {
        outputView.printStartGuide();
        getAndSaveCoaches();
        getAndSaveEachCoachHateMenu();
        List<Category> thisWeekCategories = getThisWeekCategories();
        recommendation(thisWeekCategories);
        printResult(thisWeekCategories);
    }

    private void getAndSaveCoaches() {
        outputView.printNameInputGuide();
        List<Coach> coaches = getCoaches();
        saveCoaches(coaches);
    }

    private List<Coach> getCoaches() {
        while (true) {
            try {
                List<String> coachNames = inputView.getCoachNames();
                return changeNameToCoach(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Coach> changeNameToCoach(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            Coach coach = new Coach(name);
            coaches.add(coach);
        }
        return coaches;
    }

    private void saveCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coachRepository.save(coach);
        }
    }

    private void getAndSaveEachCoachHateMenu() {
        List<Coach> coaches = coachRepository.findAll();
        for (Coach coach : coaches) {
            outputView.printHateMenuInputGuide(coach.getName());
            List<String> hateMenusNames = getHateMenuNames();
            coach.setHateMenuNames(hateMenusNames);
        }
    }

    private List<String> getHateMenuNames() {
        while (true) {
            try {
                return inputView.getHateMenuNames();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
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
        } while (category.isAlreadyRecommendedOver(MAX_NUMBER_OF_DUPLICATE));

        category.updateRecommendedCount();
        return category;
    }

    private void recommendation(List<Category> thisWeekCategories) {
        for (Category category : thisWeekCategories) {
            recommendMenuOfOneCategory(category);
        }
    }

    private void recommendMenuOfOneCategory(Category category) { // 네이밍 이상
        List<String> allMenusByCategory = menuRepository.findAllByCategory(category);
        List<Coach> coaches = coachRepository.findAll();
        for (Coach coach : coaches) {
            String menu = recommendMenuForCoach(allMenusByCategory, coach);
            coach.updateAteMenus(menu);
        }
    }

    private String recommendMenuForCoach(List<String> menus, Coach coach) {
        String menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
        } while (!coach.canEat(menu));
        return menu;
    }

    private void printResult(List<Category> thisWeekCategories) {
        Map<String, List<String>> ateMenuNamesByCoachName = coachRepository.getAteMenuNamesByCoachName();
        List<String> thisWeekCategoriesNames = thisWeekCategories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        outputView.printResult(thisWeekCategoriesNames, ateMenuNamesByCoachName);
    }
}

