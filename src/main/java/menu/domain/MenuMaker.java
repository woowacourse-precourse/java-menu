package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuMaker {

    public String generate(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);

        return menu;
    }

}
