package menu.view;

public class OutputView {

    private final String FIRST_RUN_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private final String GET_COACHES_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void startMessage() {
        System.out.println(FIRST_RUN_MESSAGE);
    }

    public void getCoachesName() {
        System.out.println(GET_COACHES_NAME_MESSAGE);
    }

}
