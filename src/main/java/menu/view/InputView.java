package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static menu.domain.CoachRepository.coaches;
import static menu.util.message.InputMessage.INPUT_CANNOT_EAT_MENU;
import static menu.util.message.InputMessage.INPUT_COACH_NAME;
import static menu.valid.InputValidator.validateCannotEatMenu;
import static menu.valid.InputValidator.validateCoachName;

public class InputView {
    OutputView outputView = new OutputView();

    public List<String> readCoachName() {
        try {
            System.out.println(INPUT_COACH_NAME);
            return validateCoachName(Console.readLine());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readCoachName();
        }
    }

    public List<String> readCannotEatMenu(int index) {
        try {
            System.out.printf(INPUT_CANNOT_EAT_MENU, coaches().get(index).getName());
            return validateCannotEatMenu(Console.readLine());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readCannotEatMenu(index);
        }
    }
}
