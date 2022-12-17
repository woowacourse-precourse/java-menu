package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.history.RecommendHistory;

public class CategoryRecommender {

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
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        return Category.valueOfCategoryNumber(categoryNumber);
    }
}
