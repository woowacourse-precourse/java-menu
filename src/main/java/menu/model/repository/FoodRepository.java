package menu.model.repository;

import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.domain.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodRepository {
    private Long id = 0L;
    private final HashMap<Long, Food> foods = new HashMap<>();

    public Long save(Food food) {
        foods.put(id, food);
        return id++;
    }

    public List<Food> findAll() {
        return new ArrayList<>(foods.values());
    }

    public Food findByName(String name) {
        return foods.values().stream()
                .filter(food -> food.getName().equals(name))
                .findFirst().orElse(null);
    }
//
//    public List<Member> findAll() {
//        return new ArrayList<>(members.values());
//    }
//
    public List<Food> findByCategory(Category category) {
        return foods.values().stream()
                .filter(x -> x.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
