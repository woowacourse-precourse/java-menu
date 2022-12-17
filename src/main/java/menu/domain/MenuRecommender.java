package menu.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {
    private final Map<DayOfWeek, List<RecommendResult>> result = new EnumMap<>(DayOfWeek.class);

    public void selectCategories(NumberGenerator numberGenerator, Group group) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            int code = numberGenerator.generate(Category.MIN_CATEGORY_CODE, Category.MAX_CATEGORY_CODE);
            List<RecommendResult> recommendResults = recommendMenu(group, Category.from(code));
            result.put(dayOfWeek, recommendResults);
        }
    }

    private List<RecommendResult> recommendMenu(Group group, Category category) {
        List<String> menuNames = Menu.findByCategory(category);
        return group.selectMenu(new RandomShuffler(), menuNames);
    }
}
