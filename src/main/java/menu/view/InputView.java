package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.Coach;
import menu.utils.CoachesConverter;

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
}
