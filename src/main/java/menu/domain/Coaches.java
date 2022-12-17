package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches = new ArrayList<>();

    public Coaches() {
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public List<String> getAllCoachesNames() {
        List<String> names = new ArrayList<>();
        for (Coach coach : coaches) {
            names.add(coach.getName());
        }
        return names;
    }

    public List<String> getCoachNames() {
        List<String> coachNames = new ArrayList<>();
        for (Coach coach : coaches) {
            coachNames.add(coach.getName());
        }
        return coachNames;
    }

    public Coach findByName(String coachName) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }
        return null;
    }


}
