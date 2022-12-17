package menu.view;

public class OutPutView {

    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_NAMES_MESSAGE = "코치의 이름을 입력해주세요. (, 로 구분)";
    private static final String REQUEST_CAN_NOT_EAT_MENU = "s%(이)가 못 먹는 메뉴를 입력해주세요";
    public static void printStartMessage (){
        System.out.println(SERVICE_START_MESSAGE);
    }

    public static void printRequestCoachNames() {
        System.out.println(REQUEST_NAMES_MESSAGE);
    }

    public static void printCatNotEatMenuEach(String name) {
        System.out.printf(REQUEST_CAN_NOT_EAT_MENU,name);
    }
}
