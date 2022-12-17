package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<String> parseByCommand(String input, String command) {
        return Arrays.stream(input.split(command)).map(String::trim).collect(Collectors.toList());
    }
}
