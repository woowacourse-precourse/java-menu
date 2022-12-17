package view;

import camp.nextstep.edu.missionutils.Console;
import dto.CoachNameResponseDto;
import dto.CoachNamesRequestDto;
import dto.InedibleMenuRequestDto;

public class InputView {

    public CoachNamesRequestDto readCoachNames() {
        System.out.println(ViewConstants.ASKING_INPUT_COACH_NAMES);
        String coachNames = Console.readLine();
        System.out.println();
        return new CoachNamesRequestDto(coachNames);
    }

    public InedibleMenuRequestDto readInedibleMenu(CoachNameResponseDto coachNameResponseDto) {
        System.out.printf(ViewConstants.ASKING_INPUT_INEDIBLE_MENU, coachNameResponseDto.getCoachName());
        System.out.println();
        String inedibleMenu = Console.readLine();
        System.out.println();
        return new InedibleMenuRequestDto(inedibleMenu);
    }
}
