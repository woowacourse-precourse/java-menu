package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.StringParser;
import menu.util.Validator;

public class Inputview {
    private static final String INPUT_MANUAL_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String PARSE_COMMAND = ",";

    public List<String> readCoachNames() {
        while (true) {
            try {
                System.out.println(INPUT_MANUAL_MESSAGE);
                String input = Console.readLine();
                Validator.validateCoachNames(input, PARSE_COMMAND);
                return StringParser.parseByCommand(input, PARSE_COMMAND);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
