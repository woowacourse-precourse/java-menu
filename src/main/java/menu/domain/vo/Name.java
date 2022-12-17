package menu.domain.vo;

import java.util.Objects;

public class Name {

    private final String name;
    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름 길이가 너무 짧습니다");
        }
        if (name.length() > 4) {
            throw new IllegalArgumentException("이름 길이가 너무 깁니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Name name1 = (Name)o;

        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }
}
