package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private static final String ERROR_MAX_SIZE = "[ERROR] 5명이상의 코치는 입력할 수 없습니다.";

    private final List<Coach> coaches = new ArrayList<>();

    public Coaches() {
    }

    public void addCoach(Coach coach) {
        validateCount(coaches.size());
        coaches.add(coach);
    }

    private void validateCount(int size) {
        if (size >= 5) {
            throw new IllegalArgumentException(ERROR_MAX_SIZE);
        }
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
