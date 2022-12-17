package menu.ui.input;

import menu.ui.input.exceptions.CoachList;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String COACH_NAME_INPUT_NOTIFICATION = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String COMMA = ",";

    public List<String> receiveCoaches() {
        Repetitor input = new CoachList();
        String coachNames = input.getResult(COACH_NAME_INPUT_NOTIFICATION);

        return Arrays.asList(coachNames.split(COMMA));
    }
}
