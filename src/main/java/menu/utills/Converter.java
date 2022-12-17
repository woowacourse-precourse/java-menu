package menu.utills;

import java.util.Arrays;
import java.util.List;

public class Converter {
    public static List<String> toListByDelimiter(String input) {
        return Arrays.asList(input.split(", "));
    }
}
