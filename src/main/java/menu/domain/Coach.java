package menu.domain;

import java.util.Objects;

public class Coach {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT = "[ERROR] 이름의 길이는 %d이상, %d이하 여야 합니다.";

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 5;

    private final String name;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT,
                    MIN_COACH_NAME_LENGTH, MAX_COACH_NAME_LENGTH));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return name.equals(coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
