package menu.view.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {
    public static final String DELIMITER = ",";
    public static final String ERROR_INVALID_FORMAT = "잘못된 형식의 입력값입니다.";

    private TextParser() {
    }

    public static List<String> parseNotEmptyLine(String readLine) {
        String[] inputValues = readLine.split(DELIMITER);
        List<String> parsedValues = Arrays.stream(inputValues)
                .map(String::trim)
                .collect(Collectors.toList());
        validateEmpty(parsedValues);
        validateValues(parsedValues);
        return parsedValues;
    }

    public static List<String> parseCouldEmptyLine(String readLine) {
        String[] inputValues = readLine.split(DELIMITER);
        List<String> parsedValues = Arrays.stream(inputValues)
                .map(String::trim)
                .collect(Collectors.toList());
        return checkContainsOnlyEmpty(parsedValues);
    }


    private static List<String> checkContainsOnlyEmpty(List<String> values) {
        if (values.size() == 1 && values.get(0).isEmpty()) {
            return new ArrayList<>();
        }
        return values;
    }

    private static void validateEmpty(List<String> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
    }

    private static void validateValues(List<String> values) {
        values.forEach(TextParser::validateValue);
    }

    private static void validateValue(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
        }
    }
}
