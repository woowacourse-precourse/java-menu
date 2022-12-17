package menu.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import menu.constant.Category;
import menu.constant.Food;
import menu.constant.Weekday;
import menu.domain.vo.Name;

public class OutputView {
    private static final String SEPARATOR = " | ";
    private static final String ELEMENTS_PRINT_FORMAT = "[ %s ]\n";
    private static final String WEEKDAY_TITLE = "구분";
    private static final String CATEGORY_TITLE = "카테고리";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printServiceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printMenus(List<Category> categories, Map<Name, List<Food>> recommendations) {
        System.out.println("메뉴 추천 결과입니다.");
        printElements(WEEKDAY_TITLE, Weekday.getNames());
        printElements(CATEGORY_TITLE, getCategoryNamesOf(categories));
        for (Name coachName : recommendations.keySet()) {
            List<Food> foodsForCoach = recommendations.get(coachName);
            printElements(coachName.getName(), getFoodNamesWithBlank(foodsForCoach));
        }
        System.out.println("추천을 완료했습니다.");
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    private List<String> getCategoryNamesOf(List<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    private List<String> getFoodNamesWithBlank(List<Food> foods) {
        return foods.stream()
                .map(Food::getNameWithBlank)
                .collect(Collectors.toList());
    }

    private void printElements(String title, List<String> elements) {
        String joinedElements = String.join(SEPARATOR, elements);
        String elementsWithTitle = String.join(SEPARATOR, title, joinedElements);
        System.out.printf(ELEMENTS_PRINT_FORMAT, elementsWithTitle);
    }
}
