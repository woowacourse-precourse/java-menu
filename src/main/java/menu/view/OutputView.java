package menu.view;

public class OutputView {

    private static final String GUIDE_START_RECOMMEND_LUNCH_MENU = "점심 메뉴 추천을 시작합니다.";
    private static final String GUIDE_INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GUIDE_INPUT_CANT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public void guideStart() {
        System.out.println(GUIDE_START_RECOMMEND_LUNCH_MENU);
    }

    public void guideInputCoachNames() {
        System.out.println();
        System.out.println(GUIDE_INPUT_COACH_NAMES);
    }

    public void guideInputCantEat(String coach) {
        System.out.println();
        System.out.println(String.format(GUIDE_INPUT_CANT_EAT, coach));
    }

}
