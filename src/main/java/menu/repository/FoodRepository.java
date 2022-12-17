package menu.repository;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    private static class InstanceHolder {
        private static final FoodRepository INSTANCE = new FoodRepository();
    }

    private List<String> foods;

    private FoodRepository() {
        foods = new ArrayList<>();
    }

    public static FoodRepository getInstance() {
        return FoodRepository.InstanceHolder.INSTANCE;
    }

    public boolean isValidFood(String foodName) {
        return foods.stream().anyMatch(foodName::equals);
    }
}
