package menu.domain;

public class Name {
    public static final int MIN_COUNT = 2;
    public static final int MAX_COUNT = 4;

    private final String name;

    public Name(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (name.length() < MIN_COUNT || name.length() > MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT);
        }
        return name;
    }

    public String getName() {
        return name;
    }

    private static final class ErrorMessage {
        private static final String INVALID_INPUT_FORMAT = String.format("코치의 이름은 최소 %d글자, 최대 %d글자여야 합니다.", MIN_COUNT, MAX_COUNT);
    }

}
