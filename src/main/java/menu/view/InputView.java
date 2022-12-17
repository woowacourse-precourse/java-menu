package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRepository;
import menu.util.CoachNameValidator;
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
        System.out.println(Message.INPUT_COACH_NAMES.message);
        List<String> coaches = Util.splitByComma(Console.readLine());
        validateCoachNumber(coaches);
        coaches.forEach(coach -> new CoachNameValidator().validate(coach));
        return convertToCoach(coaches);
    }

    private static void validateCoachNumber(List<String> coaches) {
        if (coaches.size() <= Range.MIN_NAME_LENGTH.value || coaches.size() >= Range.MAX_NAME_LENGTH.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_NUMBER.getMessage());
        }
    }

    private static List<Coach> convertToCoach(List<String> coaches) {
        return coaches.stream().map(Coach::new).collect(Collectors.toList());
    }

    public List<Menu> readMenuNotToEat(String name) {
        System.out.printf(Message.INPUT_MENU_NOT_TO_EAT.message, name);
        List<Menu> menus = Util.splitByComma(Console.readLine())
                .stream().map(MenuRepository::findByName)
                .collect(Collectors.toList());
        validateMenuNotToEatSize(menus);
        return menus;
    }

    private static void validateMenuNotToEatSize(List<Menu> menus) {
        if (menus.size() >= Range.MAX_MENU_NOT_TO_EAT_SIZE.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_NOT_TO_EAT_SIZE.getMessage());
        }
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