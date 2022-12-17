package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCouchName() {
        String names = Console.readLine();
        String[] split = names.split(",");
        return Arrays.asList(split);
    }

    public List<String> readCannotFood() {
        String names = Console.readLine();
        String[] split = names.split(",");
        return Arrays.asList(split);
    }
}
