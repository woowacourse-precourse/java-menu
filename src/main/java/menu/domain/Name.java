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
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
        return name;
    }

    public String getName() {
        return name;
    }
}
