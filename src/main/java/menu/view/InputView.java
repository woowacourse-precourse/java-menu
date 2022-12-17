package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final InputView inputView = new InputView();
    private static final InputValidator inputValidator = InputValidator.getInstance();
    private static final String SEPARATOR = ",";
    private static final String READ_COACH_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_HATE_MENU_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public List<String> readCoaches() {
        System.out.println(READ_COACH_MESSAGE);
        String input = Console.readLine();
        inputValidator.validateCoach(input);
        return decodeInput(input);
    }

    public List<String> readHateMenuOf(String coach) {
        System.out.printf(READ_HATE_MENU_FORMAT, coach);
        String input = Console.readLine();
        inputValidator.validateHateMenu(input);
        return decodeInput(input);
    }

    private List<String> decodeInput(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .collect(Collectors.toUnmodifiableList());
    }
}
