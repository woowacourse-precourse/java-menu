package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Parser;

import java.util.List;

public class InputView {

    public final static int COACH_NAME_MIN = 2;
    public final static int COACH_NAME_MAX = 4;
    public final static int COACH_LIST_MIN = 2;
    public final static int COACH_LIST_MAX = 5;
    public final static String ILLEGAL_COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자여야 합니다.";
    public final static String ILLEGAL_COACH_LIST_SIZE_ERROR_MESSAGE = "[ERROR] 코치 수는 최소 2명, 최대 5명이어야 합니다.";

    public List<String> readCoachNames() {
        String coachNames = Console.readLine();
        List<String> coachNameList = Parser.parse(coachNames);
        for (String coachName : coachNameList) {
            validateCoachName(coachName);
        }
        validateCoachNameList(coachNameList);
        return coachNameList;
    }

    public List<String> readImpossibleMenus() {
        String menu = Console.readLine();
        return Parser.parse(menu);
    }

    public void validateCoachName(String coachName) {
        if (!(coachName.length() >= COACH_NAME_MIN && coachName.length() <= COACH_NAME_MAX)) {
            throw new IllegalArgumentException(ILLEGAL_COACH_NAME_ERROR_MESSAGE);
        }
    }

    public void validateCoachNameList(List<String> list) {
        if (!(list.size() >= COACH_LIST_MIN && list.size() <= COACH_LIST_MAX)) {
            throw new IllegalArgumentException(ILLEGAL_COACH_LIST_SIZE_ERROR_MESSAGE);
        }
    }
}
