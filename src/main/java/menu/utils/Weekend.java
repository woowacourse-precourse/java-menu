package menu.utils;

import java.util.StringJoiner;

public enum Weekend {
    월요일,
    화요일,
    수요일,
    목요일,
    금요일;

    private static final String DELIMITER = " | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String INIT = "구분";

    public static int size() {
        return values().length;
    }

    public static String toMessage() {
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(INIT);
        for (Weekend value : values()) {
            joiner.add(value.name());
        }
        return PREFIX + joiner + SUFFIX;
    }
}
