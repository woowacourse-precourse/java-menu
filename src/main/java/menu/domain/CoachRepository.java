package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.utils.ErrorMessage.*;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void addCoachName(String names) {
        String[] splitNames = names.split(",");
        validateNamesCount(splitNames);
        for (String coachName : splitNames) {
            validateDuplicateName(coachName.trim());
            coaches.add(new Coach(coachName.trim()));
        }
    }

    private static void validateDuplicateName(String coachName) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(coachName)) {
                throw new IllegalArgumentException(DUPLICATE_COACH_NAME);
            }
        }
    }

    private static void validateNamesCount(String[] splitNames) {
        if (splitNames.length < 2 || splitNames.length > 5) {
            throw new IllegalArgumentException(COACH_NAMES_COUNT);
        }
    }
}
