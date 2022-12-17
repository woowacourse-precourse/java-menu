package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.InputValidator;
import menu.util.Parser;

import java.util.List;

public class InputView {

    public static final String COACH_NAME_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String FOOD_NAME_INPUT_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public List<String> readCoach() {
        printMessage(COACH_NAME_INPUT_MESSAGE);
        String names = Console.readLine();
        List<String> coachNames = Parser.getNames(names);
        InputValidator.checkNames(coachNames);
        return coachNames;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
