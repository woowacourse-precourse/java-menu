package menu.service;

import menu.domain.Coach;
import menu.repository.CoachRepository;

public class CoachService {

    private final CoachRepository coachRepository = new CoachRepository();

    public Coach addCoach(String name){
        Coach coach = new Coach(name);
        coachRepository.insertCoach(coach);
        return coach;
    }


}
