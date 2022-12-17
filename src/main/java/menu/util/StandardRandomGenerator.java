package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class StandardRandomGenerator implements RandomGenerator {

    @Override
    public String generate(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
