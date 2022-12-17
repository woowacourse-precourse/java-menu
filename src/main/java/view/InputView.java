package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCoachNames() {
        System.out.println(ViewConstants.ASKING_INPUT_COACH_NAMES);
        String coachNames = Console.readLine();
        System.out.println();
        return coachNames;
    }

    public String readInedibleMenu(String coachName) {
        System.out.printf(ViewConstants.ASKING_INPUT_INEDIBLE_MENU, coachName);
        System.out.println();
        String inedibleMenu = Console.readLine();
        System.out.println();
        return inedibleMenu;
    }
}
