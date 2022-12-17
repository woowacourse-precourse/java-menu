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
        while(categories.size() != CATEGORY_SIZE) {
            Category category = pickCategory();
            System.out.println("category.name() = " + category.name());

            categories.add(category);
        }
        categories.forEach(category -> System.out.println("category.name() = " + category.name()));
        categoryRepository.addRecommendedCategories(categories);
        return categories;
    }

    private int getFrequency(List<Category> categories, Category category) {
        List<String> categoryNames = new ArrayList<>();
        categories.forEach(c -> categoryNames.add(c.name()));

        return Collections.frequency(categoryNames, category.name());
    }

    private Category pickCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, CATEGORY_SIZE);

        if (categoryNumber == 1) {
            return JAPANESE;
        } else if (categoryNumber == 2) {
            return KOREAN;
        } else if (categoryNumber == 3) {
            return CHINESE;
        } else if (categoryNumber == 4) {
            return ASIAN;
        } else if (categoryNumber == 5) {
            return WESTERN;
        }
        return null;
    }
}
