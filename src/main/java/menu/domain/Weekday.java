package menu.domain;

public enum Weekday {
    MON("월요일"),
    TUE("화요일"),
    WEN("수요일"),
    THU("목요일"),
    FRI("금요일");

    private String name;

    Weekday(String name) {
        this.name = name;
    }
}
