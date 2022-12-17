package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Station;

public class Coach {


    private final String name;
    private final List<Food> unEatables;


    public Coach(String name) {
        this.name = name;
        this.unEatables = new ArrayList<>();
    }

    public void addUnEatable(String foods) {
        String[] names = foods.split(",");
        for (String name : names) {
            this.unEatables.add(new Food(name));
        }
    }

    public String getName() {
        return name;
    }
}

//    public static Station from(final String name) {  // 정적 팩토리 메소드
//        return new Station(name);
//    }


