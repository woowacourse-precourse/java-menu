package menu.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static List<String> restArrayToList(String restArray) {
        return Arrays.asList(restArray.split(","));
    }

}
