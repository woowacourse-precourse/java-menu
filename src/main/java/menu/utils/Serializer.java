package menu.utils;

public abstract class Serializer {
    private static final String SPACE = " ";
    private static final String NONE = "";
    private static final String COMMA = ",";

    protected static String[] serialize(final String input) {
        return input.trim()
                .replaceAll(SPACE, NONE)
                .split(COMMA);
    }
}
