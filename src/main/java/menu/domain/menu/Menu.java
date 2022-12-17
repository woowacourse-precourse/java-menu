package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.util.Categori;
import menu.util.CategoriCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public Map<String, List<String>> menus;

    public Menu() {
        menus = new HashMap<>();
    }

    public String getRandomCategoriName() {
        return Categori.getCategoriNameWithCode(getRandomNumber());
    }

    public String getRandomMenuName(String categoriName) {
        List<String> menuList = menus.get(categoriName);
        return Randoms.shuffle(menuList).get(0);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(CategoriCode.MIN.getCode(), CategoriCode.MAX.getCode());
    }

    public void addMenu(String name, List<String> menuList) {
        menus.put(name, menuList);
    }

    public Map<String, List<String>> getMenus() {
        return menus;
    }
}
