package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
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

    private List<Coach> getCoaches() {
        try {
            List<Coach> coaches = new ArrayList<>();
            addCoach(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getCoaches();
        }
    }

    private void addCoach(List<Coach> coaches) {
        List<String> coachNames = inputView.readCoach();
        for (String coachName : coachNames) {
            List<Menu> banMenu = getBanMenus(coachName);
            coaches.add(new Coach(coachName, banMenu));
        }
    }

    private List<Menu> getBanMenus(String coachName) {
        try {
            List<String> menuNames = inputView.readMenuName(coachName);
            return convertNameToMenu(menuNames);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getBanMenus(coachName);
        }
    }

    private List<Menu> convertNameToMenu(List<String> menuNames) {
        return menuNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList());
    }
}
