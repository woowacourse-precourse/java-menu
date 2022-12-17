package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Style;

public class CategoryGenerator {

    public static Style generate() {
        int input = Randoms.pickNumberInRange(1, 5);
        return Style.get(input);
    }
}
