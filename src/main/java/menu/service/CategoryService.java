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

    public List<Category> getFiveCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < CATEGORY_SIZE; i++) {
            Category category = pickCategory();
            if(getFrequency(categories, category) == 2) {
                i-=1;
                continue;
            }
            categories.add(category);
        }

        categoryRepository.addRecommendedCategories(categories);
        return categories;
    }

    private int getFrequency(List<Category> categories, Category category) {
        return Collections.frequency(categories, category);
    }

    private Category pickCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, CATEGORY_SIZE);

        if (categoryNumber == 1) {
            return JAPANESE;
        } else if (categoryNumber == 1) {
            return KOREAN;
        } else if (categoryNumber == 1) {
            return CHINESE;
        } else if (categoryNumber == 1) {
            return ASIAN;
        }
        return WESTERN;

    }
}
