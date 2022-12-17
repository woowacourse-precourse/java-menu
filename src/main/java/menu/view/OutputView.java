package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import menu.SystemMessage;

public class OutputView {

    public static final String MONDAY = "월요일";
    public static final String TUESDAY = "화요일";
    public static final String WEDNESDAY = "수요일";
    public static final String THURSDAY = "목요일";
    public static final String FRIDAY = "금요일";

    public static void printResult() {
        System.out.println(SystemMessage.RESULT_OUTPUT_MESSAGE);
        printDay();
    }

    private static void printDay() {
        StringJoiner day = new StringJoiner(" | ", "[ ", " ]");

        day.add("구분");
        day.add(MONDAY);
        day.add(TUESDAY);
        day.add(WEDNESDAY);
        day.add(THURSDAY);
        day.add(FRIDAY);

        String dayMap = day.toString();
        System.out.println(dayMap);
    }


    public static void printCategory(List<String> categories) {
        StringJoiner categoryJoiner = new StringJoiner(" | ", "[ ", " ]");

        for (String category : categories) {
            categoryJoiner.add(category);
        }

        String categoryMap = categoryJoiner.toString();
        System.out.println(categoryMap);
    }

}
