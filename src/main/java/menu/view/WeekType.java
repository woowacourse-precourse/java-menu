package menu.view;

public enum WeekType {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일"),
    SAT("툐요일"),
    SUN("일요일");

    private final String weektype;

    WeekType(String weektype) {
        this.weektype = weektype;
    }

    public String getWeektype() {
        return this.weektype;
    }
    }