package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.view.OutputView;

public class MenuRecommendController {

    private final List<Category> existCategories = new ArrayList<>();

    public void recommendWeekMenu() {
        addWeekMenuOfCoaches(CoachRepository.coaches());
        printRecommendDescription(CoachRepository.coaches());
    }

    private void addWeekMenuOfCoaches(List<Coach> coaches) {
        for (int day = 0; day < 5; day++) {
            addDayMenuOfCoaches(coaches);
        }
    }

    private void addDayMenuOfCoaches(List<Coach> coaches) {

        Category category = getValidCategory(existCategories);
        existCategories.add(category);

        for (Coach coach : coaches) {
            addMenuOfCoach(coach, category);
        }
    }

    private void addMenuOfCoach(Coach coach, Category category) {
        Menu menu = null;
        do {
            String menuName = getRandomMenuByCategory(category);
            menu = MenuRepository.findByName(menuName);
        } while (!isValidMenuForCoach(coach, menu));
        coach.addRecommendMenu(menu);
    }

    private boolean isValidMenuForCoach(Coach coach, Menu menu) {
        return !isDuplicatedForCoach(coach, menu) && isEatableMenuForCoach(coach, menu);
    }

    private boolean isDuplicatedForCoach(Coach coach, Menu menu) {
        return coach.isContainForRecommend(menu);
    }

    private boolean isEatableMenuForCoach(Coach coach, Menu menu) {
        return coach.isEatable(menu);
    }

    private String getRandomMenuByCategory(Category category) {
        return category.getRandomMenu();
    }

    private Category getValidCategory(List<Category> existCategories) {
        Category category = null;
        do {
            category = getRandomCategory();
        } while (!isValidCategory(existCategories, category));
        return category;
    }

    private Category getRandomCategory() {
        Category category = null;
        try{
            category = Category.findByNumber(Randoms.pickNumberInRange(1, 5));
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            getRandomCategory();
        }
        return category;
    }

    private boolean isValidCategory(List<Category> existCategories, Category newCategory) {
        return existCategories.stream().filter(category -> category.equals(newCategory)).count() < 2;
    }

    private void printRecommendDescription(List<Coach> coaches) {
        List<String> categoriesName = existCategories.stream()
                .map(category -> {
                    return category.getName();
                }).collect(Collectors.toList());

        Map<String, List<String>> menus = getRecommendMenusOfCoaches(coaches);
        OutputView.printWeekRecommendMenu(categoriesName, menus);
    }

    private Map<String, List<String>> getRecommendMenusOfCoaches(List<Coach> coaches) {
        Map<String, List<String>> coachMenus = new HashMap<>();
        for (Coach coach : coaches) {
            coachMenus.put(coach.getName(), coach.getRecommendMenuNames());
        }
        return coachMenus;
    }
}
