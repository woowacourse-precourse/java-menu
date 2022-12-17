package menu.domain;

public class CoachName {
    private final String name;

    private final int NAME_LENGTH_LOWERBOUND = 2;
    private final int NAME_LENGTH_UPPERBOUND = 4;
    private final String NAME_SIZE_INVALID = String.format("[ERROR] 코치의 이름은 %d글자에서 %d글자만 가능합니다.",
            NAME_LENGTH_LOWERBOUND, NAME_LENGTH_UPPERBOUND);

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!(NAME_LENGTH_LOWERBOUND <= name.length() && name.length() <= NAME_LENGTH_UPPERBOUND)) {
            throw new IllegalArgumentException(NAME_SIZE_INVALID);
        }
    }

    public String getName() {
        return name;
    }
}
