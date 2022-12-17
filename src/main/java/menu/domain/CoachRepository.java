package menu.domain;

import menu.utils.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final int MIN_NUMBER_OF_PEOPLE = 2;
    private static final int MAX_NUMBER_OF_PEOPLE = 5;

    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void addCoaches(Coach coach) {
        coaches.add(coach);
    }

    public static void validate() {
        if (coaches.size() < MIN_NUMBER_OF_PEOPLE || MAX_NUMBER_OF_PEOPLE < coaches.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SATISFIED_NUMBER_OF_COACH.get());
        }
    }

}
