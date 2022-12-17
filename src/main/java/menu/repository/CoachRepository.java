package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public void insertCoach(Coach coach) {
        coaches.add(coach);
    }

    public void removeCoach(String name) {
        coaches.stream()
                .filter(coach -> coach.getName().equals(name))
                .collect(Collectors.toList())
                .forEach(li -> coaches.remove(li));
    }

    public Optional<Coach> selectCoachByName(String name) {
        return coaches.stream()
                .filter(coach -> coach.getName().equals(name))
                .findAny();
    }
}
