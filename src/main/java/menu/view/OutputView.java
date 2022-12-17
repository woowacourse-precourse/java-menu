package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String INIT_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String MENU_OUTCOME_MESSAGE = "메뉴 추천 결과입니다.";
    public static final String OPENER_MESSAGE = "[ ";
    public static final String CLOSER_MESSAGE = " ]";
    public static final String DELIMITER = " | ";
    public static final String DAY_MESSAGE = "구분";
    public static final String CATEGORY_MESSAGE = "카테고리";
    public static final String MENU_OUTCOME_COMPLETE_MESSAGE = "추천을 완료했습니다.";


    public void showInitMessage() {
        printMessage(INIT_MESSAGE);
    }

    public void showMenus(List<Coach> coaches, List<Category> categories) {
        printMessage(MENU_OUTCOME_MESSAGE);
        printMessage(OPENER_MESSAGE + DAY_MESSAGE + DELIMITER + String.join(DELIMITER, Day.getDayNames()) + CLOSER_MESSAGE);
        printMessage(OPENER_MESSAGE + CATEGORY_MESSAGE + DELIMITER + String.join(DELIMITER, Category.getTypes(categories)) + CLOSER_MESSAGE);
        coaches.forEach(
                coach -> printMessage(OPENER_MESSAGE + coach.getName() + DELIMITER + getMenuNames(coach) + CLOSER_MESSAGE)
        );
        printMessage(MENU_OUTCOME_COMPLETE_MESSAGE);
    }

    private String getMenuNames(Coach coach) {
        return coach.getRecommendMenu()
                .stream()
                .map(menu -> menu.getName())
                .collect(Collectors.joining(DELIMITER));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
