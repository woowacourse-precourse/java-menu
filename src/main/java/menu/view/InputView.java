package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Parser;

import java.util.List;

public class InputView {

    public final static int COACH_NAME_MIN = 2;
    public final static int COACH_NAME_MAX = 4;
    public final static String ILLEGAL_COACH_NAME_ERROR_MESSAGE = "잘못된 코치 이름입니다.";

    public List<String> readCoachNames() {
        String coachNames = Console.readLine();
        List<String> coachNameList = Parser.parse(coachNames);
        for (String coachName : coachNameList) {
            validateCoachName(coachName);
        }
        return coachNameList;
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
