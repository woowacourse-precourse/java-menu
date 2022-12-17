package menu.domain;

public enum Week {
    WEEK("구분"),
    MON("월요일"),
    THU("화요일"),
    WEN("수요일"),
    THR("목요일"),
    FRI("금요일")
    ;
    private String day;

    Week(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
