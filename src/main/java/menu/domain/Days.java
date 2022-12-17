package menu.domain;

public enum Days {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금");

    private final String day;

    Days(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day;
    }
}
