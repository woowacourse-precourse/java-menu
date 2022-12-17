package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;
import menu.util.validator.CoachNameValidator;
import menu.util.ExceptionMessage;
import menu.util.Util;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<Coach> readCoachNames() {
        try {
            System.out.println(Message.INPUT_COACH_NAMES.message);
            List<String> coaches = Util.splitByComma(Console.readLine());
            validateCoachNumber(coaches);
            coaches.forEach(coach -> new CoachNameValidator().validate(coach));
            return convertToCoach(coaches);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return readCoachNames();
        }
    }

    public List<Menu> readMenuNotToEat(String name) {
        try {
            System.out.printf(Message.INPUT_MENU_NOT_TO_EAT.message, name);
            String input = Util.removeSpace(Console.readLine());
            if (input.isBlank()) {
                return List.of();
            }
            List<Menu> menus = Util.splitByComma(input)
                    .stream().map(MenuRepository::findMenuByName)
                    .collect(Collectors.toList());
            validateMenuNotToEatSize(menus);
            return menus;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return readMenuNotToEat(name);
        }
    }

    private static void validateCoachNumber(List<String> coaches) {
        if (coaches.size() <= Range.MIN_NAME_LENGTH.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SMALL_COACH_NUMBER.getMessage());
        }
        if (coaches.size() >= Range.MAX_NAME_LENGTH.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BIG_COACH_NUMBER.getMessage());
        }
    }

    private static List<Coach> convertToCoach(List<String> coaches) {
        return coaches.stream().map(Coach::new).collect(Collectors.toList());
    }


    private static void validateMenuNotToEatSize(List<Menu> menus) {
        if (menus.size() >= Range.MAX_MENU_NOT_TO_EAT_SIZE.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_NOT_TO_EAT_SIZE.getMessage());
        }
    }

    private void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        INPUT_COACH_NAMES("\n코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_MENU_NOT_TO_EAT("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

    private enum Range {
        MIN_NAME_LENGTH(1), MAX_NAME_LENGTH(6),
        MAX_MENU_NOT_TO_EAT_SIZE(3);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}