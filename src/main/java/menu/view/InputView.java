package menu.view;

import menu.Validator;
import menu.domain.Coach;
import menu.utils.Notice;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView extends Validator {
    public List<String> enterCoach() {
        try {
            List<String> coachNames = validateSeparator(readLine());
            validateCoachNumRange(coachNames);
            validateCoachNameLength(coachNames);
            return coachNames;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return enterCoach();
        }
    }

    public List<Coach> enterMenuByAll(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : coachNames) {
            List<String> menu = enterMenuByCoach(name);
            coaches.add(new Coach(name, menu));
        }
        return coaches;
    }

    public List<String> enterMenuByCoach(String name) {
        try {
            System.out.println(Notice.of(name));
            String input = readLine();
            List<String> menu = validateSeparator(input);
            validateMenuNum(menu);
            return menu;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return enterMenuByCoach(name);
        }
    }
}
