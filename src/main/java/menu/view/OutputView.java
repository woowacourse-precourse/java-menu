package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;

public class OutputView {
    public static final String DELIMITER = " | ";
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printStart() {
        System.out.println(Message.OUTPUT_START.message);
    }

    public void printResult(List<Category> categories, List<Coach> coaches) {
        System.out.println(Message.OUTPUT_MENU_RESULT.message);
        System.out.printf(Message.OUTPUT_DIVISION.message,
                formatDelimiters(Arrays.stream(Day.values()).map(Day::getName)));
        System.out.printf(Message.OUTPUT_CATEGORY_FORMAT.message,
                formatDelimiters(categories.stream().map(Category::getName)));
        for (Coach coach : coaches) {
            System.out.printf(Message.OUTPUT_MENU_FORMAT.message, coach.getName(),
                    formatDelimiters(coach.getMenuAlreadyEaten().stream().map(Menu::getName)));
        }
        System.out.println(Message.OUTPUT_FINISH_RECOMMENDATION.message);
    }


    private static String formatDelimiters(Stream<String> element) {
        return element.collect(Collectors.joining(DELIMITER));
    }

    private enum Message {
        OUTPUT_START("점심 메뉴 추천을 시작합니다."),
        OUTPUT_MENU_RESULT("\n메뉴 추천 결과입니다."),
        OUTPUT_DIVISION("[ 구분 | %s ]\n"),
        OUTPUT_CATEGORY_FORMAT("[ 카테고리 | %s ]\n"),
        OUTPUT_MENU_FORMAT("[ %s | %s ]\n"),
        OUTPUT_FINISH_RECOMMENDATION("\n추천을 완료했습니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
