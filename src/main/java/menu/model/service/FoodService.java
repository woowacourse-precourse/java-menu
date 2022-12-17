package menu.model.service;

import menu.model.domain.Food;
import menu.model.repository.FoodRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FoodService {
    private final FoodRepository foodRepository = new FoodRepository();

    public void join(Food food) {
        foodRepository.save(food);
    }

    public Food findByName(String name) {
        return foodRepository.findByName(name);
    }

    public List<String> findAllNames() {
        return foodRepository.findAll().stream()
                .map(Food::getName)
                .collect(Collectors.toList());
    }
}
