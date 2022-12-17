package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MENU_DELIMITER = " | ";
    private static final String RESULT_MESSAGE =
            "\n메뉴 추천 결과입니다."
            + "\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_RESULT_MESSAGE = "[ 카테고리 | %s ]";
    private static final String COACH_RESULT_MESSAGE = "[ %s | %s ]";
    private static final String PROGRAM_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String PROGRAM_END_MESSAGE = "\n추천을 완료했습니다.";

    public static void printError(String message){
        System.out.println(ERROR_PREFIX+message);
    }

    public void printProgramStart(){
        System.out.println(PROGRAM_START_MESSAGE);
    }

    public void printRecommendResult(Coaches coaches, List<String> categories){
        System.out.println(RESULT_MESSAGE);
        System.out.println(String.format(CATEGORY_RESULT_MESSAGE, toPrintable(categories)));
        for(Coach coach : coaches.getCoaches()){
            System.out.println(String.format(COACH_RESULT_MESSAGE,coach.getName(),
                    toPrintable(coach.getSelectedMenu())));
        }
    }

    private String toPrintable(List<String> input){
        return String.join(MENU_DELIMITER, input);
    }

    public void printProgramEnd(){
        System.out.println(PROGRAM_END_MESSAGE);
    }


}
