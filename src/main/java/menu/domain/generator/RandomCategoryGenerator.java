package menu.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import static menu.constant.SystemConstant.CATEGORY_LOWER_INCLUSIVE;
import static menu.constant.SystemConstant.CATEGORY_UPPER_INCLUSIVE;

public class RandomCategoryGenerator implements CategoryGenerator {

    @Override
    public Category generate() {
        int categoryNumber = Randoms.pickNumberInRange(CATEGORY_LOWER_INCLUSIVE, CATEGORY_UPPER_INCLUSIVE);
        return Category.from(categoryNumber);
    }
}
