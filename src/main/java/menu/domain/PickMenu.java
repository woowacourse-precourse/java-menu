package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickMenu {
    private final List<Category> categories;
    private static final int MIN_CATEGORY_NUMBER = 1;
    private static final int MAX_CATEGORY_NUMBER = 5;

    public PickMenu() {
        this.categories = getRandomCategory();
    }

    private List<Category> getRandomCategory() {
        boolean isDuplicate = true;
        List<Category> makeCategory = new ArrayList<>();
        while(isDuplicate) {
            makeCategory.clear();
            for (int i = 0; i < MAX_CATEGORY_NUMBER; i++) {
                Category category = Category.valueOfPickNumber(Randoms.pickNumberInRange(MIN_CATEGORY_NUMBER,MAX_CATEGORY_NUMBER));
                makeCategory.add(category);
            }
            isDuplicate = checkDuplicateFrequency(makeCategory);
        }
        return makeCategory;
    }

    private boolean checkDuplicateFrequency(List<Category> makeCategory) {
        if (Collections.frequency(makeCategory, Category.KOREA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.JAPAN) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.CHINA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.ASIA) > 2)
            return true;
        if (Collections.frequency(makeCategory, Category.WESTERN) > 2)
            return true;
        return false;
    }
}
