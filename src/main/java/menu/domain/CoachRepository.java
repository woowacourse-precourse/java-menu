package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }


}


