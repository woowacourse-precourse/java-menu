package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public boolean isSaveCategoryInfo(Category category) {
        return categoryRepository.isSaveCategory(category);
    }

    public Category getRecommendCategory() {
        int pickIdx = Randoms.pickNumberInRange(1, 5);
        return Category.getCategoryByIdx(pickIdx);
    }


}
