package menu.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {

    public List<String> convertToList(String input) {
        return Stream.of(input.split(","))
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());
    }
}
