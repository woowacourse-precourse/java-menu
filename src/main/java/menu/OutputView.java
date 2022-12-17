package menu;

import java.util.Arrays;
import java.util.List;

//출력 사이에 공백줄 추가 필요
//결과 테이블에서 원소 사이에 공백 추가 필요
//printResult()에서 오류

public class OutputView {
    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_INFORM_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String SERVICE_END_MESSAGE = "추천을 완료했습니다.";
    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PICKYEATINGS_INFORM_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COACH_NAME_INFORM_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final List<String> DAY_OF_THE_WEEKS = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
    private static final String DIVISION = "구분";
    private static final String CATEGORY = "카테고리";
    private static final String TABLE_PREFIX = "[ ";
    private static final String TABLE_SUFFIX = " ]";
    private static final String SEPARATOR = " | ";

    public void printStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    private void printEndMessage() {
        System.out.println(SERVICE_END_MESSAGE);
    }

    public void printCoachNameInformMessage() {
        System.out.println();
        System.out.println(COACH_NAME_INFORM_MESSAGE);
    }

    public void printPickEatingsInformMessage(String name) {
        System.out.println();
        System.out.println(name + PICKYEATINGS_INFORM_MESSAGE);
    }

    private void printResultInformMessage() {
        System.out.println();
        System.out.println(RESULT_INFORM_MESSAGE);
    }

    public void printResult(MenuRecommender menuRecommender) {
        printResultInformMessage();
        printResultTable(menuRecommender);
        printEndMessage();
    }

    private void printResultTable(MenuRecommender menuRecommender) {
        System.out.println(formatAsTable(DIVISION, DAY_OF_THE_WEEKS));
        System.out.println(formatAsTable(CATEGORY, menuRecommender.getCategories()));
        for (Member member : menuRecommender.getMembers()) {
            System.out.println(formatAsTable(member.getName(), member.getRecommendedMeal()));
        }
        System.out.println();
    }

    private String formatAsTable(String title, List<String> contents) {
        StringBuilder form = new StringBuilder();
        form.append(TABLE_PREFIX).append(title);
        for (int i = 0; i < contents.size(); i++) {
            form.append(SEPARATOR).append(contents.get(i));
        }
        form.append(TABLE_SUFFIX);

        return form.toString();
    }
}
