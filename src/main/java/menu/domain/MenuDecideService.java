package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.repository.MenuRepository;

public class MenuDecideService {
    public Coaches makeCoaches(String names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names.split(",")) {
            coaches.add(makeCoach(name));
        }
        return new Coaches(coaches);
    }

    private Coach makeCoach(String name) {
        return new Coach(name);
    }

    public CantEatMenus makeCantEatMenu(String menuNames) {
        List<Menu> menus = new ArrayList<>();
        for (String menuName : menuNames.split(",")) {
            menus.add(MenuRepository.findMenu(menuName));
        }
        return new CantEatMenus(menus);
    }
}
