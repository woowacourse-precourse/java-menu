package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachService {
    public Coach initializeCoach() {
        OutputView.messageProgramStart();
        return new Coach(getCoachNames());
    }

    private List<String> getCoachNames() {
        while (true) {
            try {
                OutputView.messageNamesInput();
                return InputView.readCoachNames();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
