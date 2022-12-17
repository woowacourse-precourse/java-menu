package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryMenu;
import menu.domain.Coach;
import menu.service.CoachFactory;
import menu.service.MenuFactory;
import menu.service.RandomCategoryFactory;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuController {
    private final List<CategoryMenu> categoryMenus;

    public MenuController(List<CategoryMenu> categoryMenus) {
        this.categoryMenus = categoryMenus;
    }

    public void start() {
        OutputView.start();
        OutputView.enterCoach();
        List<Coach> coaches = getCoaches();
        List<List<String>> cantEatMenus = getCantEatMenus(coaches);
        shuffleRandomMenu(coaches, cantEatMenus);
        OutputView.finish();
    }

    private void shuffleRandomMenu(List<Coach> coaches, List<List<String>> cantEatMenus) {
        List<Category> randomCategories = RandomCategoryFactory.randomCategory();
        List<List<String>> results = new ArrayList<>();
        for (Category randomCategory : randomCategories) {
            List<String> canEatCategoryMenus = new ArrayList<>();
            for (int i = 0; i < cantEatMenus.size(); i++) {
                canEatCategoryMenus.add(makeShuffleMenus(randomCategory, cantEatMenus.get(i), results, i));
            }
            results.add(canEatCategoryMenus);
        }
        OutputView.result(coaches, randomCategories, results);
    }

    private String makeShuffleMenus(Category randomCategory, List<String> cantEatMenus, List<List<String>> results,
                                    int index) {
        String randomCategoryMenu = "";
        for (CategoryMenu categoryMenu : categoryMenus) {
            if (categoryMenu.findSameCategory(randomCategory)) {
                randomCategoryMenu = shuffleOneMenu(categoryMenu, cantEatMenus, results, index);
            }
        }
        return randomCategoryMenu;
    }

    private String shuffleOneMenu(CategoryMenu categoryMenu, List<String> cantEatMenus, List<List<String>> results,
                                  int index) {
        String menu = "";
        while (menu.length() == 0) {
            List<String> shuffleMenus = categoryMenu.shuffleMenu();
            String shuffleMenu = shuffleMenus.get(0);
            if (cantEatMenus.contains(shuffleMenu)) {
                continue;
            }
            for (List<String> result : results) {
                if (result.get(index).equals(menu)) {
                    continue;
                }
            }
            menu = shuffleMenu;
        }
        return menu;
    }

    private List<List<String>> getCantEatMenus(List<Coach> coaches) {
        List<List<String>> cantEatMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            cantEatMenus.add(findCantEatMenu(coach));
        }
        return cantEatMenus;
    }

    private List<String> findCantEatMenu(Coach coach) {
        try {
            OutputView.cantEatMenu(coach);
            String[] inputMenus = InputView.cantEatMenus();
            return MenuFactory.makeCantEatMenus(inputMenus);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return findCantEatMenu(coach);
        }
    }

    private static List<Coach> getCoaches() {
        try {
            String[] inputCoaches = InputView.coaches();
            return CoachFactory.makeCoaches(inputCoaches);
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return getCoaches();
        }
    }
}
