package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
