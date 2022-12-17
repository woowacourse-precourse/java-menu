package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.FoodCategory;
import menu.repository.CategoryRepository;

public class CategoryService {
    private static class InstanceHolder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();

    private CategoryService(){}

    public static CategoryService getInstance() {
        return CategoryService.InstanceHolder.INSTANCE;
    }

    public String pickRandomCategory() {
        return FoodCategory.findFoodByKey(
                Randoms.pickNumberInList(FoodCategory.findKeys())
        );
    }
}
