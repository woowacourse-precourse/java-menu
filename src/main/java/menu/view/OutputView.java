package menu.view;

public class OutputView {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GET_CANT_EAT_MANUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String MENU_RESULT_INTRO = "메뉴 추천 결과입니다.";
    private static final String MENU_RESULT_ENDING = "추천을 완료했습니다.";
    private static final String SORTAION = "구분";
    private static final String CATEGORY = "카테고리";
    private static final String START_ARRAY = "[ ";
    private static final String END_ARRAY = " ]";
    private static final String SEPARATOR = " | ";

    public void printServiceStart() {
        System.out.println(SERVICE_START);
    }

    public void printGetCoachNames() {
        System.out.println(GET_COACH_NAMES);
    }

    public void printGetCantEatMenus() {
        System.out.println(GET_CANT_EAT_MANUS);
    }
}
