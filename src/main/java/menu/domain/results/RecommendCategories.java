package menu.domain.results;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.menu.MenuCategory;

public class RecommendCategories {
    private static final String RESULT_FORMAT_PREFIX = "카테고리";
    private static final int MAX_DUPLICATION_AMOUNT = 1;
    private static final int CATEGORY_MAX_SIZE = 5;

    private final List<MenuCategory> categories = new ArrayList<>();

    public void addRecommendCategory(MenuCategory menuCategory) {
        if (isAddable(menuCategory)) {
            categories.add(menuCategory);
        }
    }

    public boolean isFull() {
        return categories.size() == CATEGORY_MAX_SIZE;
    }

    private boolean isAddable(MenuCategory menuCategory) {
        long existCount = categories.stream()
                .filter(existCategory -> existCategory == menuCategory)
                .count();

        return existCount <= MAX_DUPLICATION_AMOUNT;
    }

    public List<MenuCategory> getCategories() {
        return categories;
    }

    public String resultFormat() {
        List<String> formatComponents = new ArrayList<>();
        formatComponents.add(RESULT_FORMAT_PREFIX);
        formatComponents.addAll(categories.stream().map(MenuCategory::getKoreanWord)
                .collect(Collectors.toList()));

        return formatComponents.stream().collect(Collectors.joining(
                ResultFormatConstant.RESULT_JOIN_DIAMETER,
                ResultFormatConstant.RESULT_JOIN_PREFIX,
                ResultFormatConstant.RESULT_JOIN_SUFFIX));
    }
}
