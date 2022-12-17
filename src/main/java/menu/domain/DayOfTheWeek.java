package menu.domain;

public enum DayOfTheWeek {
    월요일(0),화요일(1),수요일(2),목요일(3),금요일(4);

    int num;
    
    DayOfTheWeek(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
