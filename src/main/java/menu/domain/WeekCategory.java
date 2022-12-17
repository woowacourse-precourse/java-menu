package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WeekCategory {
    private static final int MAX_DUPLICATE_CATEGORY_COUNT = 2;
    private final Map<Day, Category> weekCategory;
    public WeekCategory(Map<Day, Category> weekCategory) {
        this.weekCategory = weekCategory;
    }

    public static WeekCategory getInstance() {
        Map<Day, Category> result = new EnumMap<>(Day.class);
        int categoryIndex = 0;

        List<Category> categories = pickCategoriesOfWeek();
        for(Day day : Day.values()) {
            result.put(day, categories.get(categoryIndex));
            categoryIndex++;
        }
        return new WeekCategory(result);
    }

    private static List<Category> pickCategoriesOfWeek() {
        List<Integer> numbers = pickCategoryNumbersOfWeek();
        return numbers.stream()
                .map(Category::getCategoryByIndex)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Integer> pickCategoryNumbersOfWeek() {
        List<Integer> result = new ArrayList<>();
        int tryCnt = Day.values().length;
        while(tryCnt > 0) {
            int number = pickNumberOfCategory();
            if(isAbleToAdd(result, number)) {
                result.add(number);
                tryCnt--;
            }
        }
        return result;
    }

    private static Integer pickNumberOfCategory() {
        List<Integer> numbers = Category.getIndexNumbers();
        return Randoms.pickNumberInList(numbers);
    }

    private static boolean isAbleToAdd(List<Integer> categoryNumbers, int target) {
        int count = (int) categoryNumbers.stream()
                .filter(number -> number == target)
                .count();
        return count < MAX_DUPLICATE_CATEGORY_COUNT;
    }

    public Category getCategoryOfDay(Day day) {
        return weekCategory.get(day);
    }

    public List<Category> getCategoriesOfWeek() {
        return weekCategory.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
