package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Menu {


    public String recommendedMenu(List<String> menus){
        String menu = Randoms.shuffle(menus).get(0);
        return menu;

    }
}
