package menu.domain.enums;

public enum Weekday {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    ;

    private final String dayName;

    Weekday(String dayName) {
        this.dayName = dayName;
    }

    public String dayName() {
        return dayName;
    }
}
