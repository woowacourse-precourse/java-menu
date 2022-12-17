package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readName() {
        System.out.println(ViewConstants.ASKING_NAME);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
