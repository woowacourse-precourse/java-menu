package menu;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 5;

    private RandomNumberGenerator() {
    }

    public static int getMenuNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
