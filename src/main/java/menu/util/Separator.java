package menu.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
public class Separator {

    public static List<String> separateCoachName(String coaches) {
        return Arrays.asList(coaches.split(","));
    }
}
