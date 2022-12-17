package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.CoachInputDTO;
import menu.dto.UnavailableMenuDTO;

public class InputView {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_UNAVAILABLE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public CoachInputDTO inputCoachName() {
        System.out.println(INPUT_COACH_NAME);
        String coachNames = Console.readLine();
        InputValidator.validateCoach(coachNames);
        return new CoachInputDTO(coachNames);
    }

    public UnavailableMenuDTO inputUnavailableMenu(String coachName) {
        System.out.println(coachName + INPUT_UNAVAILABLE_MENU);
        String unavailableMenus = Console.readLine();
        InputValidator.validateUnavailableMenus(unavailableMenus);
        return new UnavailableMenuDTO(unavailableMenus);
    }

}
