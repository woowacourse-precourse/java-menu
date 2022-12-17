package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomMenuSelector {
    public String getRandomMenu(List<String> menus) {
        String menuName = Randoms.shuffle(menus).get(0);
        System.out.println(menuName);
        return menuName;
    }
}
