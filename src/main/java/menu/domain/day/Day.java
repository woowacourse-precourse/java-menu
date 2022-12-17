package menu.domain.day;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String dayName;

    Day(String dayName) {
        this.dayName = dayName;
    }

    public static int sizeOfValues() {
        return values().length;
    }

    public String getDayName() {
        return dayName;
    }
}
