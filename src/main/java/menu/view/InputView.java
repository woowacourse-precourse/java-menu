package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coach;
import menu.utils.CoachesConverter;
import menu.utils.MenusConverter;

public class InputView {

    public List<Coach> readCoaches() {
        while (true) {
            try {
                String input = Console.readLine();
                return CoachesConverter.convert(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<String> readImpossilbeToEat() {
        while (true) {
            try {
                String input = Console.readLine();
                return MenusConverter.convert(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
