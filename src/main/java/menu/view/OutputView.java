package menu.view;

import menu.domain.Coach;

import java.util.List;

public class OutputView {

    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String SERVICE_RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String SERVICE_FINISH_MESSAGE = "\n추천을 완료했습니다.";

    public void printServiceStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printServiceFinishMessage(List<String> categories, List<Coach> coaches) {
        System.out.println(SERVICE_RESULT_MESSAGE);
        printDays();
        printCategories(categories);
        printMenus(coaches);
        System.out.println(SERVICE_FINISH_MESSAGE);
    }

    private void printDays() {
        List<String> days = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        System.out.println(Format.toString(days));
    }

    private void printCategories(List<String> categories) {
        System.out.println(Format.toString(categories));
    }

    private void printMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> menus = coach.getRecommendMenuFormat();
            System.out.println(Format.toString(menus));
        }
    }

    public void printErrorMessage(String message) {
        String errorMessage = "[ERROR] " + message;
        System.out.println(errorMessage);
    }

}
