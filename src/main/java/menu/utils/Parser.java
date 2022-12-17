package menu.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<String> parse(String text, String target){
        return Arrays.stream(text.split(target)).collect(Collectors.toList());
    }
}
