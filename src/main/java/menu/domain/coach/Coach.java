package menu.domain.coach;

public class Coach {
    private final String name;

    private Coach(String name) {
        validate(name);
        this.name = name;
    }

    public static Coach fromName(String coachName) {
        return new Coach(coachName);
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }
}
