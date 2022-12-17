package menu.view;

import camp.nextstep.edu.missionutils.Console;

import static menu.util.InputValidator.*;

public class InputView {
    public static String readCoachName() {
        OutputView.printStartMessage();
        OutputView.printInputCoachName();

        String coachName = Console.readLine();
        validateNameLength(coachName);
        validateNamesSize(coachName);
        return coachName;
    }

    public static String readHateMenu(String name) {
        OutputView.printInputHateMenu(name);

        String hateMenu = Console.readLine();
        validateMenuSize(hateMenu);
        if (name.equals("")) validateInvalidMenu(hateMenu);
        return hateMenu;
    }
}
