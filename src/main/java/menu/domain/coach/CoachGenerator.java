package menu.domain.coach;

import static menu.domain.coach.CoachRepository.getCoachRepositoryInstance;

import java.util.List;

public class CoachGenerator {

    public static void makeCoaches(List<String> coachNames) {
        for (String coachName : coachNames) {
            getCoachRepositoryInstance().addCoach(new Coach(coachName));
        }
    }
}
