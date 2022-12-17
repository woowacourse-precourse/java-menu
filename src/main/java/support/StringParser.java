package support;

import domain.Coach;
import domain.Coaches;
import domain.HateMenus;
import domain.Menu;

import java.util.ArrayList;
import java.util.List;

public final class StringParser {
    private StringParser() {}

    public static Coaches parseStringToCoachesByRest(String input) {
        String[] names = input.split(",");
        List<Coach> coachesName = new ArrayList<>();
        for (String name : names) {
            coachesName.add(new Coach(name));
        }
        return new Coaches(coachesName);
    }

    public static HateMenus parseStringToMenusByRest(String input) {
        List<Menu> menusName = new ArrayList<>();
        String[] menus = input.split(",");
        for (String menu : menus) {
            menusName.add(new Menu(menu));
        }
        return new HateMenus(menusName);
    }
}
