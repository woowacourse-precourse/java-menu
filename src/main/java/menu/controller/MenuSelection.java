package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menus;
import menu.view.Input;

public class MenuSelection {

    Input input = new Input();

    public void set() {
        List<String> names = input.inputCoachNames();
        Coaches coaches = new Coaches();
        for (String name : names) {
            List<String> unpleasantMenus = input.inputMenus(name);
            coaches.add(new Coach(name, Menus.createMenus(unpleasantMenus)));
        }

    }

}
