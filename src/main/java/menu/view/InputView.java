package menu.view;


import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.domain.coach.Coaches;
import menu.utils.CoachesInputParser;

public class InputView {

    public Coaches readCoaches() {
        String coachesInput = inputWithMessage(Messages.INPUT_COACH_NAME);
        try {
            return CoachesInputParser.parseCoaches(coachesInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCoaches();
        }
    }

    public String inputWithMessage(final Messages message) {
        System.out.println(message.getMessage());
        return inputBasicLine();
    }

    public String inputBasicLine() {
        return readLine();
    }

}
