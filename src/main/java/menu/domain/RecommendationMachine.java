package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RecommendationMachine {
    public Category category() {
        while (true) {
            Category category = randomCategory();
            if (Day.isAvailableCategory(category)) {
                return category;
            }
        }
    }

    private Category randomCategory() {
        return Category.fromCode(String.valueOf(Randoms.pickNumberInRange(1, 5)));
    }
}
