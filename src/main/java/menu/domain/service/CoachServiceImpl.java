package menu.domain.service;

import menu.domain.model.Coach;
import menu.domain.repository.CoachRepository;

public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach register(Coach coach) {
        return coachRepository.save(coach);
    }
}
