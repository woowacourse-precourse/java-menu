package menu.domain;

import java.util.List;

public class WeeklyRecommendCategory {
    private List<Integer> categoryIdxs;

    public WeeklyRecommendCategory(List<Integer> categoryIdx) {
        validate(categoryIdx);
        this.categoryIdxs = categoryIdx;
    }

    private void validate(List<Integer> categoryIdxs) {
        if (categoryIdxs.size() != Weekly.getAllDaySize()) {
            throw new IllegalArgumentException("[ERROR] 주간 음식 카테고리 오류");
        }
        for (int categoryIdx : categoryIdxs) {
            //TODO 하드코딩 변환 해야함
            if (categoryIdx < 1 || 6 < categoryIdx) {
                throw new IllegalArgumentException("없는 음식 카테고리입니다.");
            }
        }
    }

    public List<Integer> getCategoryIdxs() {
        return categoryIdxs;
    }
}
