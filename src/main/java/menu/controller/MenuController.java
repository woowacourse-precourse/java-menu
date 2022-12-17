package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.service.MenuService;
import menu.util.Log;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();

    public void run() {
        outputView.showInitMessage();
        start();
    }

    public void start() {
        List<Coach> coaches = getCoaches();
        List<Category> categories = menuService.recommend(coaches);
        outputView.showMenus(coaches, categories);
    }

    private List<Coach> getCoaches() {
        try {
            List<Coach> coaches = new ArrayList<>();
            setBanMenu(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getCoaches();
        }
    }

    private void setBanMenu(List<Coach> coaches) {
        List<String> coachNames = inputView.readCoach();
        for (String coachName : coachNames) {
            List<Menu> banMenu = getBanMenus(coachName);
            coaches.add(new Coach(coachName, banMenu));
        }
    }

    private List<Menu> getBanMenus(String coachName) {
        try {
            List<String> foodNames = inputView.readFoodName(coachName);
            return convertNameToMenu(foodNames);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getBanMenus(coachName);
        }
    }

    private List<Menu> convertNameToMenu(List<String> foodNames) {
        return foodNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList());
    }
}
