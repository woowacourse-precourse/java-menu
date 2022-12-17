package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();
    public static void saveAll(List<Coach> coachesToSave) {
        coaches.addAll(coachesToSave);
    }

    public static List<Coach> findAll() {
        return Collections.unmodifiableList(coaches);
    }
}
