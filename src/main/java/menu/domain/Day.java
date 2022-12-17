package menu.domain;

public enum Day {
    Monday("월요일"),
    TuesDay("화요일"),
    Wednesday("수요일"),
    ThursDay("목요일"),
    Friday("금요일");

    private final String day;

    Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
