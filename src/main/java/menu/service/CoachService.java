package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {
    private static class InstanceHolder {
        private static final CoachService INSTANCE = new CoachService();
    }

    private final CoachRepository coachRepository = CoachRepository.getInstance();

    private CoachService(){}

    public static CoachService getInstance() {
        return CoachService.InstanceHolder.INSTANCE;
    }

    public void registerCoach(List<String> coaches) {
        coaches.forEach(coachRepository::addCoach);
    }

    public List<String> findAllCoaches() {
        return coachRepository.findAllCoach();
    }

    public void registerInedibleFoodByCoach(String coach, List<String> foods) {
        coachRepository.addInedibleFoodToCoach(coach, foods);
    }
}
