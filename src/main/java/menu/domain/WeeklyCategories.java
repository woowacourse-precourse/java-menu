package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.type.CategoryList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCategories {

    private final List<String> categories = new ArrayList<>();

    public void pickCategories() {
        for (int i=0; i<5; i++) {
            categories.add(pickCategory());
        }
    }

    private String pickCategory() {
        while (true) {
            String category = pickRandom();
            if (Collections.frequency(categories, category) < 2) {
                return category;
            }
        }
    }

    private String pickRandom() {
        int randomCategoryCode = Randoms.pickNumberInRange(1, 5);
        for (CategoryList category : CategoryList.values()) {
            if (category.getCode() == randomCategoryCode) {
                return category.name();
            }
        }
        throw new IllegalArgumentException("프로그램이 예기치 못하게 종료되었습니다.");
    }

    public List<String> getCategoryList() {
        return Collections.unmodifiableList(categories);
    }
}
