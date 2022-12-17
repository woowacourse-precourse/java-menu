package menu.model;

import java.util.Arrays;

public enum Category {
  JAPAN(1, "일식"),
  KOREA(2, "한식"),
  CHINA(3, "중식"),
  ASIA(4, "아시안"),
  WESTERN(5, "양식");

  private int categoryId;
  private String categoryName;

  Category(int categoryId, String categoryName) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
  }

  public static Category getCategory(int categoryId) {
    return Arrays.stream(Category.values()).filter(it -> it.categoryId == categoryId).findFirst().orElseThrow(IllegalArgumentException::new);
  }
}
