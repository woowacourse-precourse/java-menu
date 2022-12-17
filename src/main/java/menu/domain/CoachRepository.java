package menu.domain;

import org.assertj.core.internal.ComparatorBasedComparisonStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoachRepository {
    public static final List<Coach> coaches = new ArrayList<>();

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public static Coach findCoachByName(String name) {
        Coach none = new Coach("none");

        for (Coach coach : coaches) {
            if (coach.getName().equals(name)) {
                return coach;
            }
        }

        return none;
    }

    public static void deleteCoach(String coachName) {
        coaches.removeIf(coach -> Objects.equals(coach.getName(), coachName));
    }

    public static void saveCoach(Coach coach) {
        deleteCoach(coach.getName());
        addCoach(coach);
    }
}
