package menu.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> parseByCommand(String input, String command) {
        return Arrays.asList(input.split(command));
    }
}
