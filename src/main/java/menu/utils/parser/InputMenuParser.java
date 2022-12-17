package menu.utils.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CategoryMenu;
import menu.service.Init;

public class InputMenuParser {

    public static  final String NAME_DELIMITER = ",";

    private InputMenuParser() {
    }

    public static List<String> parseInputMenu(final String input) {
        return parseWithCheckingEmpty(input);
    }

    private static List<String> parseWithCheckingEmpty(final String input) {
        EmptyChecker.check(input);

        Init.initiateMenu();

        return parse(input, CategoryMenu.categoryMenu());
    }

    private static List<String> parse(final String input, final List<List<String>> manuList) {
//        for (List<String> manu : manuList) {
//            if (!ContainedChecker.isValidateManu(input, manu)) {
//                throw new IllegalArgumentException("없는 메뉴 입니다.");
//            }
//        }
        return Arrays.stream(input.split(NAME_DELIMITER))
            .collect(Collectors.toList());
    }
}
