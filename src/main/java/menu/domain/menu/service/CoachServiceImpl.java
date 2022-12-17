package menu.domain.menu.service;

import menu.domain.menu.model.Coach;
import menu.domain.menu.repository.CoachRepository;

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
