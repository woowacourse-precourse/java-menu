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

  public static void addAllCategory(List<Category> categories) {
    categories.forEach(CategoryRepository::addCategory);
  }
  public static void addCategory(Category category) {
    categories.add(category);
  }
}
