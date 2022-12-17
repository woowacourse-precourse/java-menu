package menu.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.FoodRepository;
import menu.enums.Category;

public class RecommedResultDTO {

    private final List<List<String>> result = new ArrayList<>();
    private final List<String> categories = new ArrayList<>();
    private static final RecommedResultDTO recommedResultDTO = new RecommedResultDTO();

    public static RecommedResultDTO getInstance() {
        return recommedResultDTO;
    }

    public List<List<String>> getResult() {
        return Collections.unmodifiableList(result);
    }

    public List<String> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public void setResult(Map<Coach, FoodRepository> recommendedMenuToCoach) {
        result.clear();
        recommendedMenuToCoach.keySet().stream()
                .sorted()
                .forEach(coach ->
                        result.add(Stream.concat(
                                Stream.of(coach.getName()),
                                recommendedMenuToCoach.get(coach)
                                        .foods().stream()
                                        .map(Food::getName).collect(Collectors.toList())
                                        .stream())
                                .collect(Collectors.toList())));
    }

    public void setCategory(final List<Category> categories) {
        this.categories.clear();
        categories.forEach(category -> this.categories.add(category.getName()));
    }
}
