package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;

import java.util.List;

public class RecommendService {
    static final CoachRepository coachRepository = CoachRepository.getInstance();

    public List<Coach> saveCoachs(List<Coach> coaches){
        for (Coach coach:coaches) {
            coachRepository.saveCoach(coach);
        }
        return coachRepository.getCoachs();
    }


}
