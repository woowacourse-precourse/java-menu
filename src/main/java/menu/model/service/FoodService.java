package menu.model.service;

import menu.model.domain.Category;
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

    public List<String> findAllNamesByCategory(Category category) {
        return foodRepository.findAll().stream()
                .filter(x -> x.getCategory().equals(category))
                .map(Food::getName)
                .collect(Collectors.toList());
    }

    public List<Food> findByCategory(Category category) {
        return foodRepository.findByCategory(category);
    }
}
