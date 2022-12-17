package menu.domain;

public enum Category {
  Japan(1),
  Korean(2),
  China(3),
  Asian(4),
  Western(5);
  private final int category;

  Category(int category) {
    this.category = category;
  }

  public int getCategory() {
    return this.category;
  }
}
