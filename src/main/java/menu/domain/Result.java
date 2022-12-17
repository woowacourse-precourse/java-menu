package menu.domain;

import java.util.Objects;

public class Result {
    private final String name;

    private Result(String name) {
        this.name = name;
    }

    public static Result from(String name) {
        return new Result(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result that = (Result) o;
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
