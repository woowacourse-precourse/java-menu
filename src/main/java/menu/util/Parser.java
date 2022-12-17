package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";

    public static List<String> getNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
