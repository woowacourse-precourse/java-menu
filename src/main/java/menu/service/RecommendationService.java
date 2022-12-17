package menu.service;

import menu.constant.Day;
import menu.domain.Category;
import menu.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecommendationService {
    private static class InstanceHolder {
        private static final RecommendationService INSTANCE = new RecommendationService();
    }

    private final CategoryService categoryService = CategoryService.getInstance();
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private final int MAX_CATEGORIES = 2;
    private final int TOTAL_CATEGORIES = 5;

    private Map<Day, Category> categoryByDay;

    private RecommendationService() {
        List<Day> days = Arrays.stream(Day.values()).collect(Collectors.toUnmodifiableList());
        List<Category> recommendedCategories = createRecommendedCategories();
        categoryByDay = IntStream.range(0, recommendedCategories.size()).boxed()
                .collect(Collectors.toMap(days::get, recommendedCategories::get));
    }

    public static RecommendationService getInstance() {
        return RecommendationService.InstanceHolder.INSTANCE;
    }

    private List<Category> createRecommendedCategories() {
        List<String> recommendedCategories = new ArrayList<>();
        while (recommendedCategories.size() < TOTAL_CATEGORIES) {
            String pickedCategory = categoryService.pickRandomCategory();
            if (isAddableCategory(recommendedCategories, pickedCategory)) {
                recommendedCategories.add(pickedCategory);
            }
        }
        return recommendedCategories.stream().map(categoryRepository::findCategoryByName)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isAddableCategory(List<String> recommendedCategories, String categoryName) {
        return recommendedCategories.stream().filter(categoryName::equals).count() <= MAX_CATEGORIES;
    }

    public List<String> findRecommendedCategories() {
        return Arrays.stream(Day.values()).map(day -> categoryByDay.get(day))
                .map(Category::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
