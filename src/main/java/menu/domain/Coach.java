package menu.domain;

import java.util.Objects;

public class Coach {

    private final String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coach that = (Coach) o;
        return Objects.equals(name, that.name);
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
