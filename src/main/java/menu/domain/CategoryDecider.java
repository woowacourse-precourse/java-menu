package menu.domain;

import static menu.ConstantBox.CATEGORY;
import static menu.ConstantBox.MAX_CATEGORY_DUPLICATE;
import static menu.ConstantBox.RESULT_END;
import static menu.ConstantBox.RESULT_SEPARATOR;
import static menu.ConstantBox.RESULT_START;
import static menu.ConstantBox.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CategoryDecider {
    public static final String JAPAN = "일식";
    public static final String KOREAN = "한식";
    public static final String CHINA = "중식";
    public static final String ASIAN = "아시안";
    public static final String EUROPE = "양식";

    private final List<String> categories = Arrays.asList(JAPAN, KOREAN, CHINA, ASIAN, EUROPE);
    private final List<String> decidedCategory = new ArrayList<>();

    private String generateCategory() {
        return categories.get(Randoms.pickNumberInRange(1, categories.size()) - 1);
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
        return duplicateNumber < MAX_CATEGORY_DUPLICATE;
    }

    public String getDecidedCategory(int index) {
        return decidedCategory.get(index);
    }

    public String makeResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> tempCategoryData = new ArrayList<>(decidedCategory);
        tempCategoryData.add(ZERO, CATEGORY);
        stringBuilder.append(RESULT_START).append(String.join(RESULT_SEPARATOR, tempCategoryData)).append(RESULT_END);
        return stringBuilder.toString();
    }
}

