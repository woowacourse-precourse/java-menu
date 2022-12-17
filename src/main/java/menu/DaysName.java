package menu;

public enum DaysName {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String korean;

    DaysName(String name) {
        this.korean = name;
    }

    public String getKorean() {
        return korean;
    }
}
