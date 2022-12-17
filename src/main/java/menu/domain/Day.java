package menu.domain;

import java.util.List;

public class Day {

    String name;
    List<Category> day;

    public Day(String name, List<Category>day){
        this.name = name;
        this.day = day;
    }
}
