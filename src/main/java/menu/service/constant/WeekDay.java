package menu.service.constant;

public enum WeekDay {
    MON(0,"월요일"),
    TUE(1,"화요일"),
    WED(2,"수요일"),
    THU(3, "목요일"),
    FRI(4, "금요일");

    private final int index;
    private final String name;


    WeekDay(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getName() {
            return name;
        }
    public int getIndex(){
        return index;
    }
}
