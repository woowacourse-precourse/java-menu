package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.InputException;

public class InputView extends InputException {
    public List<String> readCoachName() {
        String inputData = Console.readLine();
        List<String> coachName = Arrays.stream(inputData.split(",")).collect(Collectors.toList());
        try {
            validateCoachName(coachName);
            validateCoachCount(coachName);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            readCoachName();
        }
        return coachName;
    }
}
