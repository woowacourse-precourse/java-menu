package menu.domain.coach.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import menu.domain.coach.entity.Coach;

public class CoachRepository {

    private List<Coach> coaches = new ArrayList<>();

    public void saveAll(List<Coach> coaches) {
        this.coaches.addAll(coaches);
    }

    public List<Coach> findAll() {
        return Collections.unmodifiableList(coaches);
    }

    public boolean existsByName(String coachName) {
        return coaches.stream().anyMatch(coach -> coach.matchesByName(coachName));
    }

    public Optional<Coach> findByName(String coachName) {
        return coaches.stream().filter(coach -> coach.matchesByName(coachName)).findAny();
    }
}
