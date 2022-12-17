package menu.domain.recommender;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;

public class CategoryRecommender {

    public Category recommend() {
        Category pickedCategory = pickRandomCategory();
        return pickedCategory;
    }

    private Category pickRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        return Category.valueOfCategoryNumber(categoryNumber);
    }
}
