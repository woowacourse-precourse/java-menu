package menu.domain;

import java.util.Objects;

public class Coach {

    private final String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        String notBlankName = name.trim();
        if (notBlankName.length() < 2 || notBlankName.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자이다.");
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
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
