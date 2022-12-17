package menu.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name = "";
    private List<String> hateFood = new ArrayList<>();
    private List<String> weekMenu = new ArrayList<>();

    public Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }

    public void selectMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        if (!weekMenu.contains(menu) && !hateFood.contains(menu)) {
            weekMenu.add(menu);
        } else {
            selectMenu(menus);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHateFood() {
        return hateFood;
    }

    public void setHateFood(List<String> hateFood) {
        this.hateFood = hateFood;
    }

    public List<String> getWeekMenu() {
        return weekMenu;
    }

    public void setWeekMenu(List<String> weekMenu) {
        this.weekMenu = weekMenu;
    }

}
