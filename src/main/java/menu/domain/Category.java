package menu.domain;

//TODO : 추후 enum 으로 리팩토링 필요!!!

import java.util.Objects;

public class Category {

  private String name;

  public Category(String name) {
    this.name = name;
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
    Category category = (Category) o;
    return Objects.equals(getName(), category.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
