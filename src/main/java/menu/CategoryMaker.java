package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

import java.util.HashMap;
import java.util.Map;

public class CategoryMaker {

    public void addCategory(Category category) {
        Map<Integer, Integer> categoriesCount = new HashMap<>();
        int count = 0;

        while (count < 5) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);

            if (categoriesCount.get(categoryNumber) == null) {
                category.getCategories().add(Constants.MENU_NAME.get(categoryNumber));
            } else {
                int categoryCount = categoriesCount.get(categoryNumber);
                categoryCount += 1;

                if (checkDuplicatedCount(categoryCount)) {
                    continue;
                }

                categoriesCount.put(categoryNumber, categoryCount);
                category.getCategories().add(Constants.MENU_NAME.get(categoryNumber));
            }
            count++;
        }
    }

    private boolean checkDuplicatedCount(int number) {
        return number >= 3;
    }

}
