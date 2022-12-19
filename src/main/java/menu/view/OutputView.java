package menu.view;

import menu.domain.*;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String FORBIDDEN_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private final String RESULT_START_MESSAGE = "메뉴 추천 결과입니다.";
    private final String RESULT_LAST_MESSAGE = "추천을 완료했습니다.";
    private final String BASE_ERROR_MESSAGE = "[ERROR] ";
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printSetForbiddenMenu(String coachName) {
        System.out.println(String.format(FORBIDDEN_MESSAGE, coachName));
    }

    public void printRecommendCategory(List<CategoryMenu> categoryMealHistory) {
        System.out.println(RESULT_START_MESSAGE);
        makeDayMessage();
        makeCategoryMessage(categoryMealHistory);
    }

    public void printRecommendedFood(List<String> menus, String coachName) {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add(coachName);
        for (String menu : menus) {
            messageFormat.add(menu);
        }
        System.out.println(messageFormat);
        System.out.println(RESULT_LAST_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(BASE_ERROR_MESSAGE + errorMessage);
    }

    private void makeDayMessage() {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add("구분");
        for (Day day : Day.values()) {
            messageFormat.add(day.getDay());
        }
        System.out.println(messageFormat);
    }

    private void makeCategoryMessage(List<CategoryMenu> categoryMealHistory) {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add("카테고리");
        for (CategoryMenu categoryMenu : categoryMealHistory) {
            messageFormat.add(categoryMenu.getCategoryName());
        }
        System.out.println(messageFormat);
    }
}
