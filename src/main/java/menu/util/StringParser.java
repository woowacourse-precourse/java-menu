package menu.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> getSplitList(String input) {
        return Arrays.asList(input.split(","));
    }
}
