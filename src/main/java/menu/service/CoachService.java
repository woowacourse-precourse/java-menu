package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {
    private CoachRepository coachRepository = new CoachRepository();
    public void saveCoaches(List<Coach> coaches) {
        coachRepository.saveCoaches(coaches);
    }
}