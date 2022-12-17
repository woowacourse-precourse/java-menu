package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.FoodCategory;
import menu.domain.MenuResult;

public class OutputView {
    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResult(MenuResult menuResult) {
        System.out.println("메뉴 추천 결과입니다.");
        printDays();
        printCategory(menuResult.getFoodCategories());
        printMenusByCoach(menuResult.getCoaches());
        System.out.println("추천을 완료했습니다.");
    }

    private void printDays() {
        System.out.printf("[ 구분 | %s ]\n", String.join(" | ", dayToStrings()));
    }

    private void printCategory(Map<Day, FoodCategory> foodCategory) {
        System.out.printf("[ 카테고리 | %s ]\n", String.join(" | ", convertCategoryToName(foodCategory)));
    }

    private List<String> convertCategoryToName(Map<Day, FoodCategory> foodCategories) {
        return Arrays.stream(Day.values())
                .map(foodCategories::get)
                .map(FoodCategory::getName)
                .collect(Collectors.toList());
    }

    private List<String> dayToStrings() {
        return Arrays.stream(Day.values())
                .map(Day::getName)
                .collect(Collectors.toList());
    }

    private void printMenusByCoach(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.printf("[ %s | %s ]\n", coach.getName(),
                    String.join(" | ", convertMenuToName(coach.getMenus())));
        }
    }

    private List<String> convertMenuToName(Map<Day, String> foodCategories) {
        return Arrays.stream(Day.values())
                .map(foodCategories::get)
                .collect(Collectors.toList());
    }

    public void printError(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }
}

