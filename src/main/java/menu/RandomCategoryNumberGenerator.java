package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;

public class RandomCategoryNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Category.MIN, Category.MAX);
    }
}
