package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public void printStart() {
        System.out.println(Message.OUTPUT_START.message);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printRecommendedMenus(List<Category> categories, List<Coach> coaches) {
        System.out.println(coaches);
        System.out.println(Message.OUTPUT_MENU_RESULT.message);
        System.out.println(Message.OUTPUT_DIVISION.message);
        System.out.printf(Message.OUTPUT_CATEGORY_FORMAT.message,
                categories.stream().map(Category::getName).collect(Collectors.joining(" | ")));
        for (Coach coach : coaches) {
            System.out.printf(Message.OUTPUT_MENU_FORMAT.message,
                    coach.getName(),
                    coach.getMenuAlreadyEaten().values().stream().map(Menu::getName)
                            .collect(Collectors.joining(" | ")));
        }
    }

    public void printFinishRecommendation() {
        System.out.println(Message.OUTPUT_FINISH_RECOMMENDATION.message);
    }

    private enum Message {
        OUTPUT_START("점심 메뉴 추천을 시작합니다."),
        OUTPUT_MENU_RESULT("\n메뉴 추천 결과입니다."),
        OUTPUT_DIVISION("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
        OUTPUT_CATEGORY_FORMAT("[ 카테고리 | %s ]\n"),
        OUTPUT_MENU_FORMAT("[ %s | %s ]\n"),
        OUTPUT_FINISH_RECOMMENDATION("추천을 완료했습니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
