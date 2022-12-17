package menu.domain;

public class Coach {
    private final String name;

    public Coach(String name) {
        Validator.validate(name);
        this.name = name;
    }

    private static class Validator {

        public static final String INVALID_COACH_LENGTH = "코치의 이름은 최소 2글자, 최대 4글자이다.";

        public static void validate(String name) {
            if (name.length() < 2 || 4 < name.length()) {
                throw new IllegalArgumentException(INVALID_COACH_LENGTH);
            }
        }
    }
}
