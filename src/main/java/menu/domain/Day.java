package menu.domain;

public enum Day {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THUR("목요일"),
    FRI("금요일");

    private final String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
