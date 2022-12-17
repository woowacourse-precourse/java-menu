package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.dto.CoachNameDto;
import menu.repository.CoachRepository;

public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public void saveCoach(CoachNameDto coachNames) {
        coachRepository.saveAll(coachNames.getNames());
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }
}
