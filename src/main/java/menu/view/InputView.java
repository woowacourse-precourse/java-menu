package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class InputView {

    public List<String> readCoachNames() {
        OutPutView.printStartMessage();

        OutPutView.printRequestCoachNames();
        String input = Console.readLine();

        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    public List<String> getCanNotEatMenus(String name) {
        OutPutView.printCatNotEatMenuEach(name);
        String input=Console.readLine();
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }
}
