package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coach;
import menu.utils.CoachesConverter;
import menu.utils.MenusConverter;

public class InputView {

    public List<Coach> readCoaches() {
        String input = Console.readLine();
        return CoachesConverter.convert(input);
    }

    public List<String> readHardToEat() {
        String input = Console.readLine();
        return MenusConverter.convert(input);
    }
}
