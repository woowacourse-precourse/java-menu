package menu.domain;

public enum Weekday {

    MONDAY(1, "월요일"),
    TUESDAY(2, "화요일"),
    WEDNESDAY(3, "수요일"),
    THURSDAY(4, "목요일"),
    FRIDAY(5, "금요일");

    public int weekNumber;
    public String name;

    Weekday(int weekNumber, String name) {
        this.weekNumber = weekNumber;
        this.name = name;
    }
}
