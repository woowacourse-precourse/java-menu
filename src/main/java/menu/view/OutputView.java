package menu.view;

import static java.lang.System.*;

public class OutputView {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String SERVICE_DONE = "추천을 완료했습니다.";

    public static void printServiceStart(){
        out.println(SERVICE_START);
    }
    public static void printServiceDone(){
        out.println(SERVICE_DONE);
    }

}
