package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static final List<Coach> coachs = new ArrayList<>();

    public static void add(Coach coach) {
        coachs.add(coach);
    }
}
