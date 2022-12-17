package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final String ERROR_AMOUNT = "[ERROR] 먹지 못 하는 음식은 2개 이하여야 합니다.";

    String name;
    List<Menu>cantEat;

    public Coach(String name){
        this.name = name;
    }

    public void setCantEat(List<String> cantEat) {
        if(cantEat.size()>2){
            throw new IllegalArgumentException(ERROR_AMOUNT);
        }
        List<Menu>menus = new ArrayList<>();
        for(String menu : cantEat){
            menus.add(new Menu(menu));
        }
        this.cantEat = menus;
    }

    public String getName() {
        return name;
    }

    public boolean checkCanEat(List<Menu> selectedMenus) {
        for(Menu menu : selectedMenus){
            if(cantEat.contains(menu)){
                return false;
            }
        }
        return true;
    }
}
