package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuRandomGenerator implements RandomGenerator{
    @Override
    public String generate(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
