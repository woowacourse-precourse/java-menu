package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.utils.Constants;

public class InputView {

    public String readName() {
        printForInputMessage(Constants.INPUT_NAME_MESSAGE.getConstants());

        return getInput();
    }

    public String readRemoveList(Coach coach) {
        printForInputMessage(coach.getName() + Constants.INPUT_REMOVE_LIST_MESSAGE.getConstants());

        return getInput();
    }

    public void printForInputMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return Console.readLine();
    }

}
