package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
