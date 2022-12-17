package menu;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_INFORM_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String SERVICE_END_MESSAGE = "추천을 완료했습니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PICKYEATINGS_INFORM_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COACH_NAME_INFORM_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final List<String> DAY_OF_THE_WEEKS = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
    private static final String DIVISION = "구분";
    private static final String CATEGORY = "카테고리";

    public void printStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    private void printEndMessage() {
        System.out.println(SERVICE_END_MESSAGE);
    }

    public void printCoachNameInformMessage() {
        System.out.println(COACH_NAME_INFORM_MESSAGE);
    }

    public void printPickEatingsInformMessage() {
        System.out.println(PICKYEATINGS_INFORM_MESSAGE);
    }

    private void printResultInformMessage() {
        System.out.println(RESULT_INFORM_MESSAGE);
    }

    public void printResult(MenuRecommender menuRecommender) {
        printResultInformMessage();
        printResultTalbe(menuRecommender);
        printEndMessage();
    }

    private void printResultTalbe(MenuRecommender menuRecommender) {
        System.out.println(formatAsTable(DIVISION, DAY_OF_THE_WEEKS));
        System.out.println(formatAsTable(CATEGORY, menuRecommender.getCategories()));
        for (Member member : menuRecommender.getMembers()) {
            System.out.println(formatAsTable(member.getName(), member.getRecommendedMeal()));
        }
        System.out.println();
    }

    private String formatAsTable(String title, List<String> contents) {
        StringBuilder form = new StringBuilder();
        form.append("[").append(title);
        for (int i = 0; i < contents.size(); i++) {
            form.append("|").append(contents.get(i));
        }
        form.append("]");

        return form.toString();
    }
}
