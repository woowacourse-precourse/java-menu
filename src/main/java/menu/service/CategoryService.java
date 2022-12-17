package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.FoodCategory;
import menu.domain.Category;
import menu.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private static class InstanceHolder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    private final int FIRST_ELEMENT = 0;

    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();

    private CategoryService(){}

    public static CategoryService getInstance() {
        return CategoryService.InstanceHolder.INSTANCE;
    }

    public String pickRandomCategory() {
        int key = Randoms.pickNumberInRange(1,5);
        return FoodCategory.findFoodByKey(key);
    }

    public String pickRandomFoodInCategory(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        return Randoms.shuffle(category.getAllFoods()).get(FIRST_ELEMENT);
    }
}
