package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.domain.Category;

public class MenuPicker {
    public static Category pickCategory() {
        return Category.takeRandomCategory(generateRandomValue());
    }

    private static int generateRandomValue() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
