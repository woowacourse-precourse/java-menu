package menu.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuRandomNumberGenerator {

	private static final int RANDOM_LOWER_INCLUSIVE = 1;
	private static final int RANDOM_UPPER_INCLUSIVE = 5;

	public int generate() {
		return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
	}

}
