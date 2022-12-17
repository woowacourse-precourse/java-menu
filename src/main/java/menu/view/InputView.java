package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCoachNames() {
        System.out.println(ViewConstants.ASKING_NAME);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String readInedibleMenu(String coachName) {
        System.out.printf(ViewConstants.ASKING_INEDIBLE_MENU, coachName);
        System.out.println();

        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
