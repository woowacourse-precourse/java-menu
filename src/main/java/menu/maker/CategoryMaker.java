package menu.maker;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

import java.util.HashMap;
import java.util.Map;

import static menu.global.Constants.MENU_NAME;

public class CategoryMaker {

    public void addCategory(final Category category) {
        Map<Integer, Integer> categoriesCount = new HashMap<>();
        int count = 0;

        while (count < 5) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);

            firstCategory(categoryNumber, categoriesCount, category);
            alreadyHasCategory(categoryNumber, categoriesCount, category);

            count++;
        }
    }

    private void firstCategory(final int categoryNumber,
                               final Map<Integer, Integer> categoriesCount,
                               final Category category) {

        if (categoriesCount.get(categoryNumber) != null) {
            return;
        }

        category.addCategory(MENU_NAME.get(categoryNumber));
    }

    private void alreadyHasCategory(final int categoryNumber,
                                    final Map<Integer, Integer> categoriesCount,
                                    final Category category) {

        if (categoriesCount.get(categoryNumber) == null) {
            return;
        }

        int categoryCount = categoriesCount.get(categoryNumber);
        categoryCount += 1;

        if (checkDuplicatedCount(categoryCount)) {
            return;
        }

        categoriesCount.put(categoryNumber, categoryCount);
        category.addCategory(MENU_NAME.get(categoryNumber));
    }

    private boolean checkDuplicatedCount(int number) {
        return number >= 3;
    }

}
