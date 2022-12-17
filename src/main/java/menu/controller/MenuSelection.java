package menu.controller;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuSelector;
import menu.domain.Menus;
import menu.view.Input;
import menu.view.Output;

public class MenuSelection implements Runnable {

    private final Input input = new Input();
    private final MenuSelector menuSelector;

    public MenuSelection(MenuSelector menuSelector) {
        this.menuSelector = menuSelector;
    }

    @Override
    public void run() {
        selectMenus(setCoach());
    }

    public Coaches setCoach() {
        Output.printStartMenuSelection();
        List<String> names = input.inputCoachNames();
        Coaches coaches = new Coaches();
        for (String name : names) {
            List<String> unpleasantMenus = input.inputMenus(name);
            coaches.add(new Coach(name, new Menus(unpleasantMenus)));
        }
        return coaches;
    }

    private void selectMenus(Coaches coaches) {
        List<Category> categories = menuSelector.selectCategories(coaches);
        Output.printMenusResult(categories);
        for (Coach coach : coaches.getCoaches()) {
            Output.printMenuResult(coach, menuSelector.getMenusByCoach(coach));
        }
        Output.printResultMessage();
    }

}
