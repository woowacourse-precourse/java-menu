package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;
import static menu.exception.GlobalExceptionMessage.COACH_NAME_RANGE_EXCEPTION;
import static menu.exception.GlobalExceptionMessage.COACH_SIZE_EXCEPTION;
import static menu.global.GlobalMessage.*;
import static menu.global.GlobalUnitMessage.COMMA;

public class InputView {
    public List<Coach> requestCoachesNames() {
        while (true) {
            try {
                System.out.print(ANNOUNCE_START_LUNCH_MENU_RECOMMEND.getMessage());
                System.out.print(ANNOUNCE_COACHES_NAMES.getMessage());
                String[] names = Console.readLine().split(COMMA.getMessage());
                validateNameSize(names);
                validateCoachSize(names);
                return parseCoaches(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateCoachSize(String[] inputName) {
        if (2 > inputName.length || inputName.length > 5) {
            throw new IllegalArgumentException(COACH_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateNameSize(String[] inputName) {
        List<String> names = List.of(inputName);
        boolean isRangeOver = names.stream().anyMatch(name -> 2 > name.length() || name.length() > 4);
        if (isRangeOver) {
            throw new IllegalArgumentException(COACH_NAME_RANGE_EXCEPTION.getMessage());
        }
    }

    private List<Coach> parseCoaches(String[] names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }
}
