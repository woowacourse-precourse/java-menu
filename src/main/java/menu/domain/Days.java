package menu.domain;

import java.util.List;

public class Days {

    List<Day> days;

    public Days(List<Day>days){
        this.days = days;
    }

    public Menu findMenu(String menu) {
        for(Day day : days){
            if(day.haveMenu(menu)){
                return day.findMenu(menu);
            }
        }
        throw new IllegalArgumentException("[ERROR] 없는 메뉴입니다.");
    }
}
