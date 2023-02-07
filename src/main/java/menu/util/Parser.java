package menu.util;

import menu.model.domain.Coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> splitInfo(String info) {
        return Arrays.stream(info.split(",")).collect(Collectors.toList());
    }
}
