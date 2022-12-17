package menu.util;

import java.util.Arrays;
import java.util.List;

public class Separator {

    public List<String> separateNames(String names) {
        return Arrays.asList(names.split(names));
    }

}
