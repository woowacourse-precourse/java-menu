package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final static String delimiter = ",";

    public List<String> parse(String str) {
        ArrayList<String> list = new ArrayList<>();
        String[] split = str.split(delimiter);
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        return list;
    }
}
