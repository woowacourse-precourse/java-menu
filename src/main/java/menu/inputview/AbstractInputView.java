package menu.inputview;

import camp.nextstep.edu.missionutils.Console;

public abstract class AbstractInputView {
    protected static String readInput() {
        return Console.readLine();
    }
}
