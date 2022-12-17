package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class CategoryRepository {

  private static final List<Category> categories = new ArrayList<>();

  public static List<Category> categories() {
    return Collections.unmodifiableList(categories);
  }

  public static void addStation(Category category) {
    categories.add(category);
  }
}
