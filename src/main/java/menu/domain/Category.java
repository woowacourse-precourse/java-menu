package menu.domain;

public enum Category {
  Japan("일식"),
  Korean("한식"),
  China("중식"),
  Asian("아시안"),
  Western("양식");
  private final String category;

  Category(String category) {
    this.category = category;
  }

  public String getCategory() {
    return this.category;
  }
}
