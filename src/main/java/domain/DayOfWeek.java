package domain;

public enum DayOfWeek {
    MON("월요일"), TUE("화요일"), WED("수요일"), THU("목요일"), FRI("금요일");

    private final String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isLastDayOfWeek(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRI;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
