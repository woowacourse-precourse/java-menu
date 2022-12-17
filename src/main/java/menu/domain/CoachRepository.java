package menu.domain;

import java.util.*;

public class CoachRepository {
    private static final List<String> coachNames = new ArrayList<>();

    public static void nameRegistration(List<String> names) {
        for (String name : names) {
            coachNames.add(name);
        }
    }
}
