package menu.constant;

import java.util.List;

public enum Day {
    MONDAY("월요일", 0),
    TUESDAY("화요일", 1),
    WEDNESDAY("수요일", 2),
    THURSDAY("목요일", 3),
    FRIDAY("금요일", 4);

    private String name;
    private int order;
    private static final Day[] days = Day.values();

    Day(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName(){
        return name;
    }

    public int getOrder(){

    }

    public static Day get(int index){
        return days[index];
    }

    public static int size(){
        return days.length;
    }


}
