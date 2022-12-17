package menu.domain;

public class Coach {

    private static final int VALID_NAME_LOWER_BOUND = 2;
    private static final int VALID_NAME_UPPER_BOUND = 4;
    private static final String INVALID_NAME_MESSAGE = "코치님의 이름은 2 ~ 4글자여야 합니다.";

    private final String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < VALID_NAME_LOWER_BOUND || VALID_NAME_UPPER_BOUND < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
