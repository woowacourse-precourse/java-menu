package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CategoryGenerator {
    public Category pick(){
        return Arrays.stream(Category.values())
                .collect(Collectors.toList())
                .get(Randoms.pickNumberInRange(1, 5));
    }
}
