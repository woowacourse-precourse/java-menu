package menu.domain;

import java.util.Arrays;
import java.util.List;

public class CoachService {

    public void registerCoaches(String input) {
        String[] coaches = input.split(",");
        for (String coach :
                coaches) {
            CoachRepository.addCoach(new Coach(coach));
        }
    }

    public void registerCannotEatFoods(Coach coach, String input) {
        String[] foods = input.split(",");
        coach.setCannotEatFoods(Arrays.asList(foods));
    }

    public List<Coach> getCoaches() {
        return CoachRepository.coaches();
    }

}
