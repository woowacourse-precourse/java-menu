package menu.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import menu.Domain.MenuRepository;

public class InputView {
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_NAME_LENGTH = 2;

    private static final int MAX_COACH_NUMBER = 5;
    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_UNFAVORED_MENU_SIZE = 2;
    private static final String COMMA_REGEX = ",";

    public static List<String> readCoachNames() {
        InfoMessages.INPUT_COACH_NAMES.println();
        String input = Console.readLine();
        List<String> inputList = new ArrayList<>();
        for (String inputSplit : input.split(COMMA_REGEX)) {
            isInLength(inputSplit);
            inputList.add(inputSplit);
        }
        isInSize(inputList);
        hasSameName(inputList);
        return inputList;
    }

    public static List<String> readUnfavorMenuList() {
        String input = Console.readLine();
        List<String> inputList = new ArrayList<>();
        if (input.isEmpty()) {
            return inputList;
        }
        for (String inputSplit : input.split(COMMA_REGEX)) {
            inputList.add(inputSplit);
            for (String menuName : inputList) {
                isInMenu(menuName);
            }
        }
        overMinSize(inputList);
        hasSameName(inputList);
        return inputList;
    }

    private static void overMinSize(List<String> inputList) {
        if (inputList.size() > MAX_UNFAVORED_MENU_SIZE) {
            throw new IllegalArgumentException(InfoMessages.ERROR_MENU_NUMBER.getMessage());
        }
    }

    private static void isInMenu(String menuName) {
        if (!MenuRepository.validateMenu(menuName)) {
            throw new IllegalArgumentException(InfoMessages.ERROR_MENU_NAME.getMessage());
        }
    }

    private static void isInLength(String inputSplit) {
        if (inputSplit.length() < MIN_COACH_NAME_LENGTH || inputSplit.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(InfoMessages.ERROR_COACH_NAME_LENGTH.getMessage());
        }
    }

    private static void hasSameName(List<String> inputList) {
        if (Set.copyOf(inputList).size() != inputList.size()) {
            throw new IllegalArgumentException(InfoMessages.ERROR_SAME_NAME.getMessage());
        }
    }

    private static void isInSize(List<String> inputList) {
        if (inputList.size() < MIN_COACH_NUMBER || inputList.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(InfoMessages.ERROR_COACH_NUMBER.getMessage());
        }
    }
}
