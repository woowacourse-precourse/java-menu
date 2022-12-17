package menu.domain;

public class CoachName {
    private static final int NAME_LENGTH_MIN = 2;
    private static final int NAME_LENGTH_MAX = 4;

    private final String name;


    private CoachName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static CoachName from(String name) {
        return new CoachName(name);
    }

    private void validateNameLength(String name) {
        if (name.length()<NAME_LENGTH_MIN || name.length()>NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }
}