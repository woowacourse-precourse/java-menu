package menu;

public class OutputView {
    private static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_INFORM_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String SERVICE_END_MESSAGE = "추천을 완료했습니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PICKYEATINGS_INFORM_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String COACH_NAME_INFORM_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void printStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(SERVICE_END_MESSAGE);
    }

}
