package menu.view;

public class OutputView {
    public static final String START_DINNER_MENU_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    public static final String RESULT_MENU_RECOMMEND = "메뉴 추천 결과입니다.";
    public static final String FINISH_MENU_RECOMMEND = "추천을 완료했습니다.";
    public static final String DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    //메뉴 추천 시작 메세지 출력
    public static void printStart() {
        System.out.println(START_DINNER_MENU_RECOMMEND);
        printBreak();
    }

    //메뉴 추천 결과
    public static void printResult() {
        System.out.println(RESULT_MENU_RECOMMEND);
        System.out.println(DAYS);
        //.out.println(a);
        //printBreak();
    }

    //추천 완료 메세지 출력
    public static void printFinish() {
        System.out.println(FINISH_MENU_RECOMMEND);
        //시스템 종료
    }

    //에러 메세지 출력
    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
        printBreak();
    }

    //줄 바꿈 출력
    public static void printBreak() {
        System.out.println();
    }
}
