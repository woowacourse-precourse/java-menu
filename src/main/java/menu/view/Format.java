package menu.view;

import java.util.List;

public class Format {

    private static final String BEGIN = "[ ";
    private static final String END = " ]";
    private static final String DIVISION = " | ";

    public static String toString(List<String> data) {
        StringBuilder result = new StringBuilder();

        result.append(BEGIN);
        String history = String.join(DIVISION, data);
        result.append(history);
        result.append(END);

        return result.toString();
    }

}
