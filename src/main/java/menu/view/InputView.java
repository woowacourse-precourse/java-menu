package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public final static int COACH_NAME_MIN = 2;
    public final static int COACH_NAME_MAX = 4;
    public final static String ILLEGAL_COACH_NAME_ERROR_MESSAGE = "잘못된 코치 이름입니다.";

    public String readCoachName() {
        String coachName = Console.readLine();
        validateCoachName(coachName);
        return coachName;
    }

    public String readImpossibleMenu() {
        String menu = Console.readLine();
        return menu;
    }

    public void validateCoachName(String coachName) {
        if (!(coachName.length() >= COACH_NAME_MIN && coachName.length() <= COACH_NAME_MAX)) {
            throw new IllegalArgumentException(ILLEGAL_COACH_NAME_ERROR_MESSAGE);
        }
    }
}
