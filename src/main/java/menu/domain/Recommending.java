package menu.domain;

import java.util.Objects;

public class Recommending {
    private final Coach coach;
    private final Category category;
    private final Menu menu;

    public Recommending(Coach coach, Category category, Menu menu) {
        this.coach = coach;
        this.category = category;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Recommending{" +
                "coach=" + coach +
                ", category=" + category +
                ", menu=" + menu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommending that = (Recommending) o;
        return coach.equals(that.coach) && category == that.category && menu.equals(that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, category, menu);
    }
}
