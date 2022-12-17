package menu.view.coach;

import camp.nextstep.edu.missionutils.Console;
import menu.view.DefaultInputView;

public class CoachInputView extends DefaultInputView {

    private static final String COACH_INPUT_GUIDE_MESSAGE = "코치의 이름을 입력해 주세요. (%s 로 구분)";
    private static final String COACH_NOT_EAT_MENU_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String INPUT_EXCEPTION_MESSAGE = "필요한 구분자가 누락되었습니다.";

    private static final String INPUT_SEPARATOR = ",";

    private CoachInputView() {
    }

    private static class CoachInputViewSingletonHelper {
        private static final CoachInputView COACH_INPUT_VIEW = new CoachInputView();
    }

    public static CoachInputView getInstance() {
        return CoachInputViewSingletonHelper.COACH_INPUT_VIEW;
    }

    public String readCoachesName() {
        String coachesName = processInput(String.format(COACH_INPUT_GUIDE_MESSAGE, INPUT_SEPARATOR));

        validateInput(coachesName);
        validateCoachesName(coachesName);
        return coachesName;
    }

    private void validateCoachesName(String coachesName) {
        if (!coachesName.contains(INPUT_SEPARATOR)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    public String readCoachesNotEatMenusName(String coachName) {
        return processInput(String.format(COACH_NOT_EAT_MENU_MESSAGE, coachName));
    }

    private String processInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
