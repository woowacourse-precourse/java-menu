package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

    private static final String COMMA = ",";

    public List<String> toStrList(String input) {
        return Stream.of(input.split(COMMA))
                .collect(Collectors.toList());
    }
}
