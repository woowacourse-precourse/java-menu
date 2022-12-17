package menu.view;

import java.util.List;
import java.util.stream.Collectors;

import menu.constant.Category;
import menu.constant.Food;
import menu.domain.Coach;

public class OutputView {
    private static final String SEPARATOR = " | ";

    public void printServiceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printMenus(List<Category> categories, List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        printElements("구분", List.of("월요일", "화요일", "수요일", "목요일", "금요일"));
        printElements("카테고리", getCategoryNames(categories));
        for (Coach coach : coaches) {
            printElements(coach.getName(), getFoodNamesWithBlank(coach.getRecommendedFoods()));
        }
        System.out.println("추천을 완료했습니다.");
    }

    private List<String> getCategoryNames(List<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    private List<String> getFoodNamesWithBlank(List<Food> foods) {
        return foods.stream()
                .map(Food::getNameWithBlank)
                .collect(Collectors.toList());
    }

    private void printElements(String name, List<String> elements) {
        String joinedElements = String.join(SEPARATOR, elements);
        System.out.printf("[ %s ]\n", String.join(SEPARATOR, name, joinedElements));
    }
}
