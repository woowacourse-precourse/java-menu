package menu;

public enum Week {
    MONDAY("월요일"),
    SATURDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String value;

    Week(String value) {
        this.value = value;
    }

}
