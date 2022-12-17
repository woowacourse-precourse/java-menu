package menu.domain;

import java.util.*;

public class CoachRepository {
    private static final List<String> coachNames = new ArrayList<>();
    private static final Map<String, List<String>> coachHateMenu = new HashMap<>();

    public static void nameRegistration(List<String> names) {
        coachNames.addAll(names);
    }

    public static void hateMenuRegistration(String name, List<String> menu) {
        coachHateMenu.put(name, menu);
    }

    public static List<String> getCoachNames() {
        return coachNames;
    }

    public static Map<String, List<String>> getCoachHateMenu() {
        return coachHateMenu;
    }
}
