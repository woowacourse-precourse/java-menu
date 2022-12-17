package menu.domain.model;

public enum Day {

    MON(0, "월요일"),
    TUE(1, "화요일"),
    WED(2, "수요일"),
    THUR(3, "목요일"),
    FRI(4, "금요일");

    private final int index;
    private final String name;

    Day(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }
}
