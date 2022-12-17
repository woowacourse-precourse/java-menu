package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRandomGenerator{

    private static final int FIRST_INDEX = 0;

    public String generate(List<String> menus) {
        return Randoms.shuffle(menus).get(FIRST_INDEX);
    }
}
