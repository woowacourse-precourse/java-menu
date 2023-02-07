package menu.model.service;

import menu.model.domain.Coach;
import menu.model.domain.Food;
import menu.model.repository.CoachRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoachService {
    private final CoachRepository coachRepository = new CoachRepository();

    public void join(Coach coach) {
        coachRepository.save(coach);
    }

    public List<String> findAllNames() {
        return coachRepository.findAll().stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public Coach findByName(String name) {
        return coachRepository.findByName(name);
    }

//    public List<Coach> findByCannotEatFood(List<Food> Foods) {
//        return coaches.values().stream()
//                .filter(x -> x.getCannotEatFoods().contains(Foods))
//                .collect(Collectors.toList());
//    }
}
