package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class Converter {

    public static List<Coach> stringToCoaches(String coaches) {
        String[] splitCoaches = coaches.split(",");
        return Arrays.stream(splitCoaches)
            .map(Coach::new)
            .collect(Collectors.toList());
    }
}
