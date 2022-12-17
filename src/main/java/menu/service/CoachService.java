package menu.service;

import menu.domain.coach.Coach;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {
    public void addCoaches(List<String> coachNames) {
        coachNames.stream()
                .map(Coach::new)
                .forEach(CoachRepository::addCoach);
    }
}
