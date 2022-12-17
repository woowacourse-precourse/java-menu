package menu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformInput {
    public static List<String> splitInput(String input) {
        String[] transformInput = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        return Arrays.asList(transformInput);
    }

    public static List<Integer> convertType(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
