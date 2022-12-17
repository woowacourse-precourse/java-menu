package menu.domain;

public enum Day {
  Mon(1),
  Tue(2),
  Wed(3),
  Thu(4),
  Fri(5);
  private final int day;

  Day(int day) {
    this.day = day;
  }

  public int getDay() {
    return this.day;
  }

}
