package menu.util;

import java.util.Arrays;
import java.util.List;

public class Separator {

    public List<String> separateCoachNames(String coachNames) {
        return Arrays.asList(coachNames.split(coachNames));
    }
}
