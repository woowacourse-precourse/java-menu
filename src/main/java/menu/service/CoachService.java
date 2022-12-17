package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.domain.NotEatFoods;
import menu.repository.CoachRepository;
import menu.repository.NotEatFoodRepository;

public class CoachService {

    public static void addCoach(String name) {
        Coach newCoach = new Coach(name);
        CoachRepository.addCoach(newCoach);
        NotEatFoodRepository.addInitNotEatFood(new NotEatFoods(newCoach));
    }

    public static void addCoaches(List<String> names) {
        names.stream()
                .forEach(name -> addCoach(name));
    }

    public static List<Coach> findAllCoaches() {
        return CoachRepository.findAll();
    }



}
