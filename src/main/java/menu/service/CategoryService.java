package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.domain.Category.*;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final static Integer CATEGORY_SIZE = 5;

    public List<Category> getRecommendedCategories() {
        return categoryRepository.findCategories();
    }

    public List<Category> getFiveCategories() {
        List<Category> categories = new ArrayList<>();
        List<Integer> categoryIds = new ArrayList<>();

        while (categories.size() != CATEGORY_SIZE) {
            int categoryId = pickCategory();
            if (getFrequency(categoryIds, categoryId) != 2) {
                categoryIds.add(categoryId);
                categories.add(Category.findById(categoryId));
            }
        }
        categoryRepository.addRecommendedCategories(categories);
        return categories;
    }

    private int getFrequency(List<Integer> categoryIds, Integer categoryId) {
        return Collections.frequency(categoryIds, categoryId);
    }

    private int pickCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, CATEGORY_SIZE);

        return categoryNumber;
    }
}
