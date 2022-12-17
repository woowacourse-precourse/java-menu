package menu.model.repository;

import menu.model.domain.Coach;
import menu.model.domain.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoachRepository {
    private Long id = 0L;
    private final Map<Long, Coach> coaches = new HashMap<>();

    public Long save(Coach coach) {
        coaches.put(id, coach);
        return id++;
    }

    public Coach findByName(String name) {
        return coaches.values().stream()
                .filter(coach -> coach.getName().equals(name))
                .findFirst().orElse(null);
    }

    public List<Coach> findAll() {
        return new ArrayList<>(coaches.values());
    }

    public List<Coach> findByCannotEatFood(List<Food> Foods) {
        return coaches.values().stream()
                .filter(x -> x.getCannotEatFoods().contains(Foods))
                .collect(Collectors.toList());
    }

    public void saveCannotEatFood(Coach coach, List<Food> food) {
        coach.setCannotEatFoods(food);
    }
}
