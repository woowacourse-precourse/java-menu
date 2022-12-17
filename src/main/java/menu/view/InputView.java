package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.CoachRepository;

import java.util.List;

import static menu.util.InputValidator.validateNameLength;
import static menu.util.InputValidator.validateNamesSize;

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
        return hateMenu;
    }
}
