package menu.domain;

import java.util.List;

import static menu.constatnts.Constants.*;

public class WeeklyRecommendCategory {
    private List<Integer> categoryIdxs;

    public WeeklyRecommendCategory(List<Integer> categoryIdx) {
        validate(categoryIdx);
        this.categoryIdxs = categoryIdx;
    }

    private void validate(List<Integer> categoryIdxs) {
        if (categoryIdxs.size() != Weekly.getAllDaySize()) {
            throw new IllegalArgumentException(ERROR_WEEKLY_CATEGORY_SIZE);
        }
        for (int categoryIdx : categoryIdxs) {
            if (categoryIdx < CATEGORY_START_NUM || CATEGORY_END_NUM < categoryIdx) {
                throw new IllegalArgumentException(ERROR_NONE_CATEGORY);
            }
        }
    }

    public List<Integer> getCategoryIdxs() {
        return categoryIdxs;
    }
}
