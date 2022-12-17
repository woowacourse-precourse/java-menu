package menu.domain.menu.repository;

import java.util.List;
import menu.domain.menu.model.Food;
import menu.domain.menu.type.Category;

public interface FoodRepository {

    List<Food> findByCategory(Category category);
}
