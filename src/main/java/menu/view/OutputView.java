package menu.view;

public class OutputView {

    public static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String CANT_EAT_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";


    public void printFeatures() {
        System.out.println(START_MESSAGE);
        System.out.println();
        System.out.println(INPUT_COACH_NAME);
    }

    public void printCantEatMenu(String coachName) {
        System.out.println(String.format(CANT_EAT_MENU, coachName));
    }
}
