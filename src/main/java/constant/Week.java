package constant;

public enum Week {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String weekday;

    Week(String weekday) {
        this.weekday = weekday;
    }



}