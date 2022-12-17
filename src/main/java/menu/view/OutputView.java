package menu.view;

import menu.domain.Coach;

import java.util.List;

public class OutputView {

    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String SERVICE_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    public void printServiceStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printServiceFinishMessage(List<String> categories, List<Coach> coaches) {
        System.out.println(SERVICE_RESULT_MESSAGE);
        List<String> days = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        System.out.println(Format.toString(days));
        System.out.println(Format.toString(categories));
        for (Coach coach : coaches) {
            List<String> menus = coach.requestFormat();
            System.out.println(Format.toString(menus));
        }
    }
}
