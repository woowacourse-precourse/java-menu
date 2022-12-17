package menu.util;

import java.util.Arrays;
import java.util.List;

public class Separator {
    private final static String SEPARATOR = ",";

    public List<String> separateNames(String names) {
        List<String> strings = Arrays.asList(names.split(SEPARATOR));
        return strings;
    }

}
