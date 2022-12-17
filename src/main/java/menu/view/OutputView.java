package menu.view;

public class OutputView {
    public static final String START_DINNER_MENU_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    public static final String RESULT_MENU_RECOMMEND = "메뉴 추천 결과입니다.";
    public static final String FINISH_MENU_RECOMMEND = "추천을 완료했습니다.";



    //메뉴 추천 시작 문구
    public static void printStart() {
        System.out.println(START_DINNER_MENU_RECOMMEND);
        printBreak();
    }



    public static void printBreak() {
        System.out.println();
    }
}
