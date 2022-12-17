package menu.recommendation;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

import java.util.*;

public class RecommendationGenerator {
    /**
     * 일주일치의 카테고리를 미리 계산한다.
     *
     * @return
     */
    public List<Category> recommendCategory() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() != 5) {
            Category category = categoryConvertor(Randoms.pickNumberInRange(1, 5));
            if (Collections.frequency(categories, category) == 2)
                continue;
            categories.add(category);
        }

        return categories;
    }

    /**
     * 숫자타입을 Enum타입의 카테고리로 변경한다.
     *
     * @param pickNum
     * @return
     */
    public Category categoryConvertor(int pickNum) {
        if (pickNum == 1)
            return Category.JAPANESE;
        if (pickNum == 2)
            return Category.KOREAN;
        if (pickNum == 3)
            return Category.CHINESE;
        if (pickNum == 4)
            return Category.ASIAN;
        if (pickNum == 5)
            return Category.WESTERN;
        return null;
    }
}
