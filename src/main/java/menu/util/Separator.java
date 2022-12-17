package menu.util;

import java.util.Arrays;
import java.util.List;

public class Separator {
    private final static String SEPARATOR = ",";

    public List<String> separateNames(String names) {
        String replacedNames = names.replace(" ", "");
        List<String> strings = Arrays.asList(replacedNames.split(SEPARATOR));
        return strings;
    }

}
