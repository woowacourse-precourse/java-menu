package menu.utils;

import java.util.function.Function;
import java.util.stream.Stream;
import menu.domain.coach.Coaches;

public class CoachesInputParser {

    public static Coaches parseCoaches(final String input) {
        return parseWithCheckingEmpty(input, Coaches::from);
    }

    private static <T> T parseWithCheckingEmpty(final String input, final Function<String, T> function) {
        EmptyAndNullChecker.check(input);
        return parseWithApply(input, function);
    }

    private static <T> T parseWithApply(final String input, final Function<String, T> function) {
        return Stream.of(input)
            .map(String::trim)
            .filter(str -> str.matches(Constants.KOREAN))
            .map(function)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Constants.ERROR_INPUT));
    }
}
