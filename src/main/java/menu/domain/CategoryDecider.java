package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CategoryDecider {
    private final List<String> categories = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
    private final List<String> decidedCategory = new ArrayList<>();

    private String generateCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5) - 1);
    }

    public void setCategory() {
        boolean successToSetCategory;
        do {
            successToSetCategory = selectCategory();
        } while (!successToSetCategory);
    }

    private boolean selectCategory() {
        String category = generateCategory();
        if (checkCategoryDuplicationNumber(category)) {
            decidedCategory.add(category);
            return true;
        }
        return false;
    }

    private boolean checkCategoryDuplicationNumber(String category) {
        long duplicateNumber = decidedCategory.stream()
                .filter(cate -> Objects.equals(cate, category))
                .count();
        return duplicateNumber <= 2;
    }

    public List<String> getDecidedCategory() {
        return decidedCategory;
    }
}

