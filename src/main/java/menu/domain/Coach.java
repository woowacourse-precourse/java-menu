package menu.domain;

import java.util.List;

public class Coach {

    String name;
    List<Menu>cantEat;

    public Coach(String name){
        this.name = name;
    }

    public void setCantEat(List<Menu> cantEat) {
        if(cantEat.size()>2){
            throw new IllegalArgumentException("[ERROR] 먹지 못 하는 음식은 2개 이하여야 합니다.");
        }
        this.cantEat = cantEat;
    }

    public String getName() {
        return name;
    }
}
