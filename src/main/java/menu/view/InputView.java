package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.CoachInputDTO;

public class InputView {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_UNAVAILABLE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public CoachInputDTO inputCoachName() {
        String coachNames = Console.readLine();
        InputValidator.validateCoach(coachNames);
        return new CoachInputDTO(coachNames);
    }


}
