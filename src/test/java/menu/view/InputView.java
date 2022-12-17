package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCoachNameList() {
        return Arrays.asList(Console.readLine().split(","));
    }
}
