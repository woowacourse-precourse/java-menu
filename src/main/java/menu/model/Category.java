package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {

    private final List<String> categories;

    public Category() {
        categories = new ArrayList<>();
        categories.add("카테고리");
    }

    public void addCategoryCandidate() {
        Map<Integer, Integer> categoriesCount = new HashMap<>();
        int count = 0;

        while (count < 5) {
            int category = Randoms.pickNumberInRange(1, 5);

            if (categoriesCount.get(category) == null) {
                categories.add(Constants.MENU_NAME.get(category));
            } else {
                int categoryCount = categoriesCount.get(category);
                categoryCount += 1;

                if (checkDuplicatedCount(categoryCount)) {
                    continue;
                }

                categoriesCount.put(category, categoryCount);
            }
            count++;
        }
    }

    private boolean checkDuplicatedCount(int number) {
        return number >= 3;
    }

    public List<String> getCategories() {
        return categories;
    }
}
