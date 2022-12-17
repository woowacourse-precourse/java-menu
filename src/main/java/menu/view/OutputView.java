package menu.view;

public class OutputView {

    private static final String GUIDE_START_RECOMMEND_LUNCH_MENU = "점심 메뉴 추천을 시작합니다.";
    private static final String GUIDE_INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void guideStart() {
        System.out.println(GUIDE_START_RECOMMEND_LUNCH_MENU);
    }

    public void guideInputCoachNames() {
        System.out.println(GUIDE_INPUT_COACH_NAMES);
    }

}
