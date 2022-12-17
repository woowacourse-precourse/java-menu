package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.model.Menu;
import menu.model.MenuRepository;
import menu.util.StringParser;
import menu.util.Validator;

public class Inputview {
    private static final String MANUAL_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String CANT_EAT_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String PARSE_COMMAND = ",";

    public List<String> readCoachNames() {
        while (true) {
            try {
                System.out.println(MANUAL_MESSAGE);
                String input = Console.readLine();
                Validator.validateCoachNames(input, PARSE_COMMAND);
                return StringParser.makeListByCommand(input, PARSE_COMMAND);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Menu> readCantEats(String name, MenuRepository menus) {
        while (true) {
            try {
                System.out.println();
                System.out.println(name + CANT_EAT_MESSAGE);
                String input = Console.readLine();
                Validator.validateMenuNum(input, PARSE_COMMAND);
                return StringParser.makeMenuListByCommand(input, PARSE_COMMAND, menus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
