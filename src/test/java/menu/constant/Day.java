package menu.constant;

import java.util.List;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String name;
    private static final Category[] days = Category.values();

    Day(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Category get(int index){
        return days[index];
    }

    public static int size(){
        return days.length;
    }


}
