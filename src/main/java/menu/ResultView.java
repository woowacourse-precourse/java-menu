package menu;

import java.util.List;

public class ResultView {

    private static final String OLD_DELIMITER = ",";
    private static final String DELIMITER = " |";
    private static final String OLD_LEFT = "[";
    private static final String LEFT = "[ ";
    private static final String OLD_RIGHT = "]";
    private static final String RIGHT = " ]";
    private static final int FIRST_PLACE = 0;

    private ResultView() {}

    public static String print(String name, List<String> result) {
        result.add(FIRST_PLACE, name);
        return result.toString().replace(OLD_LEFT, LEFT).replace(OLD_RIGHT, RIGHT).replace(OLD_DELIMITER, DELIMITER);
    }
}
