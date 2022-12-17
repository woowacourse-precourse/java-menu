package menu.view;

import menu.dto.RecommendResultDTO;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class OutputView {

    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private final String RESULT_WEEKDAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String RESULT_CATEGORY = "카테고리";
    private final String RESULT_PREFIX = "[ ";
    private final String RESULT_MID = " | ";
    private final String RESULT_SUFFIX = " ]";
    private final String END_MESSAGE = "추천을 완료했습니다.";

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(RecommendResultDTO recommendResultDTO) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_WEEKDAY);
        System.out.println(toListForm(RESULT_CATEGORY, recommendResultDTO.getCategories()));
        Map<String, List<String>> menus = recommendResultDTO.getMenus();
        for (String coachName : menus.keySet()) {
            System.out.println(toListForm(coachName, menus.get(coachName)));
        }
        System.out.println();
        System.out.println(END_MESSAGE);
    }

    private String toListForm(String header, List<String> contents) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_PREFIX);
        stringBuilder.append(header);
        for (String content : contents) {
            stringBuilder.append(RESULT_MID);
            stringBuilder.append(content);
        }
        stringBuilder.append(RESULT_SUFFIX);
        return stringBuilder.toString();
    }
}
