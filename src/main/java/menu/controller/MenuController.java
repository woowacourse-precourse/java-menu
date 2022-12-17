package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.MenuCategory;
import menu.domain.MenuRecommender;
import menu.domain.Menu;
import menu.domain.MenuRepository;
import menu.domain.MenuResult;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private MenuRecommender recommender;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printStart();
        initMenus();
        List<Coach> coaches = getCoaches();
        for (Coach coach : coaches) {
            addBlacklist(coach);
        }
        MenuResult menuResult = recommender.recommendByDay();
        outputView.printResult(menuResult);
    }

    private void initMenus() {
        List<List<String>> menusByCategory = Arrays.stream(MenuCategory.values())
                .map(MenuCategory::getFoods)
                .collect(Collectors.toList());
        for (List<String> menus : menusByCategory) {
            menus.stream()
                    .map(Menu::new)
                    .forEach(MenuRepository::addMenu);
        }


    }

    private void addBlacklist(Coach coach) {
        try {
            List<Menu> menus = findAll(inputView.readBlackList(coach));
            coach.setBlacklist(menus);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            addBlacklist(coach);
        }
    }

    private List<Menu> findAll(List<String> names) {
        return names.stream()
                .filter(name -> !name.equals(""))
                .map(MenuRepository::findByName)
                .collect(Collectors.toList());
    }

    private List<Coach> getCoaches() {
        try {
            List<Coach> coaches = readCoaches();
            recommender = new MenuRecommender(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getCoaches();
        }
    }

    private List<Coach> readCoaches() {
        return inputView.readCoaches()
                .stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
