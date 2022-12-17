package menu.domain;

import java.util.Objects;

public class Menu {

  private Category category;
  private String name;

  public Menu(Category category, String name) {
    this.category = category;
    this.name = name;
  }

  public Category getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(getCategory(), menu.getCategory()) && Objects.equals(
        getName(), menu.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCategory(), getName());
  }
}
