package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryRecommendRepository {

    private static final int ALLOW_DUPLICATE_UPPER_BOUND = 2;
    private static final String INVALID_WEEKDAY_MESSAGE = "해당 요일의 추천 카테고리가 없습니다. 올바른 요일을 입력해주세요.";

    private static final List<CategoryRecommend> categoryRecommends = new ArrayList<>();

    public static void addRecommend(CategoryRecommend categoryRecommend) {
        categoryRecommends.add(categoryRecommend);
    }

    public static CategoryRecommend findByWeekday(Weekday weekday) {
        return categoryRecommends.stream()
                .filter(categoryRecommend -> categoryRecommend.hasSameWeekday(weekday))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_WEEKDAY_MESSAGE));
    }

    // TODO 테스트 코드 효율화
    public static boolean hasOverDuplicatedCategory(Category category) {
        return countDuplicatedCategory(category) > ALLOW_DUPLICATE_UPPER_BOUND;
    }
    
    // TODO 테스트 코드
    public static long countDuplicatedCategory(Category category) {
        return categoryRecommends.stream()
                .filter(categoryRecommend -> categoryRecommend.hasSameCategory(category))
                .count();
    }

    public static List<CategoryRecommend> getAll() {
        return Collections.unmodifiableList(categoryRecommends);
    }
}
