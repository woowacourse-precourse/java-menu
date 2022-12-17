package menu.domain;

public class Coach {
    private final String name;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_NAME_LENGTH = 2;
    private static final String INVALID_NAME_MESSAGE = "유효하지 않은 이름입니다.";


    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if(!isValidLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    private static boolean isValidLength(String name) {
        return MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }
}
