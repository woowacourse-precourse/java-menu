package menu.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    private Util() {
    }

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    public static List<String> splitByComma(String input) {
        return Arrays.asList(Util.removeSpace(input).split(Regex.COMMA.regex));
    }

    private enum Regex {
        SPACE(" "), NO_SPACE(""),
        COMMA(",");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

}
