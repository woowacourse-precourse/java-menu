package menu.util.converter;

import java.util.Arrays;
import java.util.List;

public class ArrayConverter {

    public static List<String> restArrayToList(String restArray) {
        return Arrays.asList(restArray.split(","));
    }

}
