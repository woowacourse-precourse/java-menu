package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CategoryGenerator {
    public Category pick(HashMap<Category, Integer> categoryCounter) {
        int flag = 3;
        Category pick = null;
        while (flag >= 2) {
            pick = Arrays.stream(Category.values())
                    .collect(Collectors.toList())
                    .get(Randoms.pickNumberInRange(1, 5));
            flag = categoryCounter.get(pick);
        }
        return pick;
    }
}
