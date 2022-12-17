package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Menu {
    private String menu;

    Menu(List<String> menus){
        String menu = Randoms.shuffle(menus).get(0);
    }

    public String getMenuName(){
        return menu;
    }
}
