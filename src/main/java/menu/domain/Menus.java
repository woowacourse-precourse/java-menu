package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Menus {
    private final List<String> menus;

    private Menus(List<String> menus) {
        this.menus = menus;
    }

    public static Menus from(List<String> menus) {
        return new Menus(menus);
    }

    public boolean hasMenu(String name) {
        return menus.contains(name);
    }

    public String getRandomMenu() {
        return Randoms.shuffle(this.menus).get(0);
    }
}
