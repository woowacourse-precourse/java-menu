package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.repository.CoachRepository;

public class CoachService {

    public static void addCoach(String name) {
        CoachRepository.addCoach(new Coach(name));
    }

    public static void addCoaches(List<String> names) {
        names.stream()
                .forEach(name -> addCoach(name));
    }

}
