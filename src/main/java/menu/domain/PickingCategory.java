package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class PickingCategory {

    public Category getCategoryByPickingNumber() {
        Category[] categories = Category.values();
        return categories[getPickingNumber()];
    }

    public int getPickingNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
