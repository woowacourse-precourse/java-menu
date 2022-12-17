package menu.model;

public enum Day {
    MON("월요일"),
    TUE("화요일"),
    WEN("수요일"),
    THU("목요일"),
    FRI("금요일");

    private String day;

    Day(String day) {
        this.day = day;
    }
}
