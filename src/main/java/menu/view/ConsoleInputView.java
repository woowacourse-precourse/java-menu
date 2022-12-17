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
        String inputStr = Console.readLine().trim();
        if(inputStr.equals("")) {
            return new ArrayList<>();
        }

        String[] stringList = inputStr.split(",");

        List<String> output = new ArrayList<>();
        Collections.addAll(output, stringList);
        return output;
    }
}
