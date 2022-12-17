package menu.view;

public enum Day {
    MON("월요일"),
    TUES("화요일"),
    WED("수요일"),
    THURS("목요일"),
    FRI("금요일");

    private final String korean;


    Day(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
