package menu.View;

import java.util.List;

import menu.Model.Coach;
import menu.Model.Coachs;

public class Outputview {
    private final List<String> WEEKDAYS = List.of("월요일", "화요일", "수요일", "목요일", "금요일");
    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private final String END_MESSAGE = "추천을 완료했습니다.";
    private final String ERROR_PREFIX = "[ERROR] ";

    private void printBlank() {
        System.out.println();
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
        this.printBlank();
    }

    public void printEnd() {
        System.out.println(END_MESSAGE);
    }

    public void printResult(Coachs coachs, List<String> pickCategories) {
        System.out.println(RESULT_MESSAGE);
        printWeekDays();
        printCategories(pickCategories);
        for (Coach coach : coachs.getCoachs()) {
            printRecommend(coach);
        }
        this.printBlank();
    }

    private void printWeekDays() {
        System.out.println(makeResultView("구분", WEEKDAYS));
    }

    private void printCategories(List<String> pickCategories) {
        System.out.println(makeResultView("카테고리", pickCategories));
    }

    private void printRecommend(Coach coach) {
        System.out.println(makeResultView(coach.getName(), coach.getRecommends()));
    }

    private String makeResultView(String head, List<String> list) {
        String elements = String.format("[ %s | ", head);
        elements += String.join(" | ", list);
        elements += " ]";
        return elements;
    }

    public void printError(String Message) {
        System.out.println(ERROR_PREFIX + Message);
    }
}
