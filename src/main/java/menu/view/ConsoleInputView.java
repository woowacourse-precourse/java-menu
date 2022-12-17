package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleInputView {
    public String readString() {
        return Console.readLine();
    }

    public List<String> readStringList() {
        String[] stringList = Console.readLine().split(",");

        List<String> output = new ArrayList<>();
        Collections.addAll(output, stringList);
        return output;
    }
}
