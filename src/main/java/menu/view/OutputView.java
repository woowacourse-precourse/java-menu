package menu.view;

import java.util.List;

public class OutputView {

    private static final String GUIDE_START_RECOMMEND_LUNCH_MENU = "점심 메뉴 추천을 시작합니다.";
    private static final String GUIDE_INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GUIDE_INPUT_CANT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT = "메뉴 추천 결과입니다.";
    private static final String RESULT_ARGUMENT = "[ %s ]";
    private static final String RESULT_SEPARATOR = " | ";
    private static final String COMPLETION = "추천을 완료했습니다.";

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

    public void guideShowResult() {
        System.out.println();
        System.out.println(RESULT);
    }

    public void showResult(List<String> line) {
        System.out.println(String.format(RESULT_ARGUMENT, String.join(RESULT_SEPARATOR, line)));
    }

    public void guideComplete() {
        System.out.println();
        System.out.println(COMPLETION);
    }

}
