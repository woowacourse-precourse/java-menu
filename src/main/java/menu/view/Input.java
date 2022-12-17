package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readCoachNames() {
        return read();
    }

    public String read() {
        return Console.readLine();
    }
}
