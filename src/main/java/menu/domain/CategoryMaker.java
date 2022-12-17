package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CategoryMaker {

    public Category generate() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);

        for (Category category : Category.values()) {
            if (category.getCode() == randomNumber) {
                return category;
            }
        }

        return null;
    }

}
