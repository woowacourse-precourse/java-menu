package menu.view;

import static menu.domain.MenuGiver.ASIAN_MENU;
import static menu.domain.MenuGiver.CHINA_MENU;
import static menu.domain.MenuGiver.EUROPE_MENU;
import static menu.domain.MenuGiver.JAPAN_MENU;
import static menu.domain.MenuGiver.KOREAN_MENU;

import java.util.ArrayList;
import java.util.List;

public class AllMenu {
    static List<String> allMenu;

    static List<String> getAllMenu() {
        if (allMenu == null) {
            allMenu = new ArrayList<>(JAPAN_MENU);
            allMenu.addAll(KOREAN_MENU);
            allMenu.addAll(CHINA_MENU);
            allMenu.addAll(ASIAN_MENU);
            allMenu.addAll(EUROPE_MENU);
        }
        return allMenu;
    }
}
