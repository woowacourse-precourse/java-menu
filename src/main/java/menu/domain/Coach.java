package menu.domain;

import java.util.Objects;

public class Coach {
    public static final int minSize = 2;
    public static final int maxSize = 5;
    private final String name;

    public Coach(String name) {
        Validator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                '}';
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

    private static class Validator {

        public static final String INVALID_COACH_LENGTH = "코치의 이름은 최소 2글자, 최대 4글자이다.";

        public static void validate(String name) {
            if (name.length() < 2 || 4 < name.length()) {
                throw new IllegalArgumentException(INVALID_COACH_LENGTH);
            }
        }
    }
}
