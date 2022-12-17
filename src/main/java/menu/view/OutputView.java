package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.MenuCategory;
import menu.domain.Menu;
import menu.domain.MenuResult;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String FINISH_MESSAGE = "추천을 완료했습니다.";
    private static final String DAYS_MESSAGE = "구분";
    private static final String CATEGORY_MESSAGE = "카테고리";
    private static final String RESULT_BASIC_FORMAT = "[ %s | %s ]\n";
    private static final String DELIMITER = " | ";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(MenuResult menuResult) {
        System.out.println(RESULT_MESSAGE);
        printDays();
        printCategory(menuResult.getFoodCategories());
        printMenusByCoach(menuResult.getCoaches());
        System.out.println(FINISH_MESSAGE);
    }

    private void printDays() {
        printBasicFormat(DAYS_MESSAGE, dayToStrings());
    }

    private void printCategory(Map<Day, MenuCategory> foodCategory) {
        printBasicFormat(CATEGORY_MESSAGE, convertCategoryToName(foodCategory));
    }

    private List<String> convertCategoryToName(Map<Day, MenuCategory> foodCategories) {
        return Arrays.stream(Day.values())
                .map(foodCategories::get)
                .map(MenuCategory::getName)
                .collect(Collectors.toList());
    }

    private List<String> dayToStrings() {
        return Arrays.stream(Day.values())
                .map(Day::getName)
                .collect(Collectors.toList());
    }

    private void printMenusByCoach(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printBasicFormat(coach.getName(), convertMenuToName(coach.getMenus()));
        }
    }

    private void printBasicFormat(String subject, List<String> elements) {
        System.out.printf(RESULT_BASIC_FORMAT, subject, String.join(DELIMITER, elements));
    }

    private List<String> convertMenuToName(Map<Day, Menu> foodCategories) {
        return Arrays.stream(Day.values())
                .map(foodCategories::get)
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public void printError(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}

