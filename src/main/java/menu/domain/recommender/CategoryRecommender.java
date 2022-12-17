package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.history.RecommendHistory;

public class CategoryRecommender {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 5;
    private final RecommendHistory history;

    public CategoryRecommender(RecommendHistory history) {
        this.history = history;
    }

    public Category recommend() {
        Category pickedCategory;
        do {
            pickedCategory = pickRandomCategory();
        } while (!history.canRecommend(pickedCategory));
        return pickedCategory;
    }

    private Category pickRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return Category.valueOfCategoryNumber(categoryNumber);
    }
}
