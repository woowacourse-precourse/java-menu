package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
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

    private void recommendation(List<Category> thisWeekCategories){
        List<Coach> coaches = coachRepository.findAll();
        for (Category category : thisWeekCategories) {
            recommendMenuOfOneCategory(category);
        }
    }

    private void recommendMenuOfOneCategory(Category category){ // 네이밍 이상
        List<Menu> allMenusByCategory = menuRepository.findAllByCategory(category);
        List<Coach> coaches = coachRepository.findAll();
        for (Coach coach : coaches) {
            Menu menu = recommendMenuForCoach(allMenusByCategory, coach);
            coach.updateAteMenus(menu);
        }
    }

    private Menu recommendMenuForCoach(List<Menu> menus, Coach coach){
        Menu menu;
        do{
            menu = Randoms.shuffle(menus).get(0);
        } while(!coach.canEat(menu));
        return menu;
    }
}

