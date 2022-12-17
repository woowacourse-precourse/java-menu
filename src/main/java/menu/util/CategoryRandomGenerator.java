package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.Category;

import java.util.List;


public final class CategoryRandomGenerator implements RandomGenerator {

    @Override
    public String generate(List<String> list) {
        return Category.getByOrdinal(Randoms.pickNumberInRange(1, 5));
    }
}
