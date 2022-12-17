package menu.domain;

import java.util.List;
import java.util.Objects;

public class Coach {
    private final String coachName;
    private final List<String> notEatFoods;

    public Coach(String coachName, List<String> notEatFoods) {
        this.coachName = coachName;
        this.notEatFoods = notEatFoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(coachName, coach.coachName) && Objects.equals(notEatFoods, coach.notEatFoods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachName, notEatFoods);
    }
}

