package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recommendation {
    public static final String ALREADY_FULLY_RECOMMENDED = "이미 모든 요일의 추천이 완료되었습니다.";
    public List<Category> categories = new ArrayList<>();

    public Recommendation() {
    }

    public Category addCategory() {
        preventAddingIfCategoryIsFull();
        Category categoryForDay = recommendCategoryForDay();
        categories.add(categoryForDay);
        return categoryForDay;
    }

    private void preventAddingIfCategoryIsFull() {
        if (categories.size()>=5) {
            throw new IllegalStateException(ALREADY_FULLY_RECOMMENDED);
        }
    }

    private Category recommendCategoryForDay() {
        int alreadyCategoryCount;
        Category category;
        do {
            category = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
            alreadyCategoryCount = countAlreadyRecommendedCategory(category);
        } while (alreadyCategoryCount >= 2);
        return category;
    }

    private int countAlreadyRecommendedCategory(Category finalCategory) {
        return (int) categories.stream()
                .filter(c -> c.equals(finalCategory))
                .count();
    }

    @Override
    public String toString() {
        String joinWithDelimiter = categories.stream().map(Category::getName).collect(Collectors.joining(" | "));
        return String.format("[ 카테고리 | %s ]", joinWithDelimiter);
    }
}
