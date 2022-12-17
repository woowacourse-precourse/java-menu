package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coachList = new ArrayList<>();

    public static void saveCoach(Coach coach) {
        coachList.add(coach);
    }

    public static List<Coach> findAllCouch() {
        return coachList;
    }
}
