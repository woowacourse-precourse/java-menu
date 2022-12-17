package menu.view;

import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Menu;

public class OutPutView {

    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String REQUEST_NAMES_MESSAGE = "코치의 이름을 입력해주세요. (, 로 구분)";
    private static final String REQUEST_CAN_NOT_EAT_MENU = "%s(이)가 못 먹는 메뉴를 입력해주세요";
    private static final String START_PRE_FIX = "[";
    private static final String END_PRE_FIX = "]";
    private static final String DELIMITER = "구분 |";

    public static void printStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
        System.out.println();
    }

    public static void printRequestCoachNames() {
        System.out.println(REQUEST_NAMES_MESSAGE);
        System.out.println();
    }

    public static void printCatNotEatMenuEach(String name) {
        System.out.printf(REQUEST_CAN_NOT_EAT_MENU, name);
        System.out.println();
    }

    public static void printResult(Map<String, List<Menu>> recommend) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
        StringBuilder sb = new StringBuilder();
        for (String name : recommend.keySet()) {
            sb.append("[");
            sb.append(name + " | ");
            for (Menu menu : recommend.get(name)) {
                sb.append(menu.getName()+" | ");
            }
            sb.append("]");
            sb.append("\n");
        System.out.println(sb.deleteCharAt(sb.length()-2));
        }
            System.out.println("추천을 완료했습니다");

}


    public static void printError(IllegalArgumentException exception) {
        System.out.println("[ERROR]" + exception.getMessage());
    }
}


