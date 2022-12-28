package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.util.Message;

public class InputView {
    private static final String COMMA = ",";
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_MENU_LENGTH = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MIN_COACH_COUNT = 2;

    OutputView outputView = new OutputView();

    public List<String> getCoachList() {
        outputView.initMessage();
        String coachString = Console.readLine();
        List<String> coachList = Arrays.asList(coachString.split(COMMA));
        validateCoachNameLength(coachList);
        if (coachList.size() > MAX_COACH_COUNT || coachList.size() < MIN_COACH_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_COACH_COUNT.getErrMessage());
        }
        return coachList;
    }

    private static void validateCoachNameLength(List<String> coachList) {
        for (int i = 0; i < coachList.size(); i++) {
            if (coachList.get(i).length() < MIN_NAME_LENGTH || coachList.get(i).length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(Message.ERROR_COACH_NAME_LENGTH.getErrMessage());
            }
        }
    }

    public List<String> getHateList(String name) {
        outputView.askCoachHate(name);
        String hateString = Console.readLine();
        if (hateString == null) {
            return List.of();
        }
        if (!(hateString.contains(COMMA))) {
            return List.of(hateString);
        }
        List<String> hateFoodList = Arrays.asList(hateString.split(COMMA));
        if (hateFoodList.size() > MAX_MENU_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_MENU_COUNT.getErrMessage());
        }
        return hateFoodList;
    }

}
