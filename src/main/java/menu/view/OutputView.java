package menu.view;

import menu.dto.WeekDietDto;

public class OutputView {
    private static final String ERROR_PRINT_FORMAT = "[ERROR] %s";
    private static final String RECOMAND_DONE_FORMAT = "메뉴 추천 결과입니다.";
    private static final String OVER_MSG = "추천을 완료했습니다.";

    public static void printErrorMsg(String error_msg){
        System.out.println(String.format(ERROR_PRINT_FORMAT,error_msg));
    }

    public static void printWeekDiet(WeekDietDto weekDietDto){
        System.out.println();
        System.out.println(RECOMAND_DONE_FORMAT);
        System.out.println(weekDietDto);
    }

    public static void printOver(){
        System.out.println(OVER_MSG);
    }
}
