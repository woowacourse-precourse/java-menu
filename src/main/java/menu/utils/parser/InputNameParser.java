package menu.utils.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.CoachList;

public class InputNameParser {
    public static  final String NAME_DELIMITER = ",";

    private InputNameParser() {
    }

    public static CoachList parseInputName(final String input) {
        return parseWithCheckingEmpty(input);
    }

    private static CoachList parseWithCheckingEmpty(final String input) {
        EmptyChecker.check(input);

        List<Coach> coachList = parse(input);

        return CoachList.from(coachList);
    }

    private static List<Coach> parse(final String input) {
        return Arrays.stream(input.split(NAME_DELIMITER))
            .map(String::trim)
            .filter(i -> 2 <= i.length() && i.length() <= 5)
            .map(Coach::from)
            .collect(Collectors.toList());
    }

}
