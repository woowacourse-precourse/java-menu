package menu.view;

import menu.domain.Category;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.MenuHistory;
import menu.domain.WeekCategory;
import menu.service.MenuService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView outputView = new OutputView();
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";

    private static final String SEPARATOR = " | ";
    private static final String FORMAT = "[ %s | %s ]";
    private static final String QUIT_MESSAGE = "추천을 완료했습니다.";


    private static final String ERROR = "[ERROR] ";
    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printDays() {
        String days = Arrays.stream(Day.values())
                .map(Day::getName)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(String.format(FORMAT, "구분", days));
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCategory(WeekCategory weekCategory) {
        String categories = weekCategory.getCategoriesOfWeek().stream()
                .map(Category::getName)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(String.format(FORMAT, "카테고리", categories));
    }

    public void printMenus(List<String> menus, String name) {
        String history = String.join(SEPARATOR, menus);
        System.out.println(String.format(FORMAT, name, history));
    }

    public void printQuit() {
        System.out.println(QUIT_MESSAGE);
    }

    public void printError(String error) {
        System.out.println(ERROR + error);
    }
}
