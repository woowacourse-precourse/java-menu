package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCoachName() {
        printInputCoachName();

        String names = Console.readLine();
        List<String> coachNames = convertNameStringToList(names);

        while (handlingCoachNameException(coachNames)) {
            printInputCoachName();
            names = Console.readLine();

            coachNames = convertNameStringToList(names);
        }

        return coachNames;
    }

    private List<String> convertNameStringToList(String names) {
        return Arrays.stream(names.split(","))
                     .collect(Collectors.toList());
    }

    private boolean handlingCoachNameException(final List<String> names) {
        try {
            for (String name : names) {
                InputValidator.isCorrectLength(name);
            }
            InputValidator.isLimit(names.size());
            return false;
        } catch (IllegalArgumentException retry) {
            System.out.println(retry.getMessage());
        }
        return true;
    }

    private void printInputCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }
}
