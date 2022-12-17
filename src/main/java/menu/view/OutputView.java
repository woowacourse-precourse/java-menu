package menu.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR = "[ERROR] ";
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String END_MESSAGE = "추천을 완료했습니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RECOMMEND_RESULT);
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void printWeek() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printRecommendCategory(List<String> category) {
        System.out.println(formattedCategory(category));
    }

    public void printRecommendMenu(List<String> food, String name) {
        System.out.println("[ " + name + formattedMenu(food));
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }

    private String formattedMenu(List<String> menu) {
        return menu.stream()
                .collect(Collectors.joining(" | ", " | ", " ]"));
    }

    //Todo: 이거 형식 %s 형태로 받아서 출력하기
    private String formattedCategory(List<String> category) {
        return category.stream()
                .collect(Collectors.joining(" | ", "[ 카테고리 | ", " ]"));
    }
}
