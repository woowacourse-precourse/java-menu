package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public Integer generateCategoryIdx() {
        return Randoms.pickNumberInRange(1, 5) - 1;
    }
}
