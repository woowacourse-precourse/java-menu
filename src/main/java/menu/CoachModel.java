package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CoachModel {
    private final String name;
    private final List<String> cantEatMenu = new ArrayList<>();
    private final List<String> Menu = new ArrayList<>();

    public CoachModel(String name) {
        this.name = name;
    }

    public void makeMenu(List<String> menuList){
        String menu = Randoms.shuffle(menuList).get(0);
        while(Menu.contains(menu)||cantEatMenu.contains(menu)){
            menu = Randoms.shuffle(menuList).get(0);
        }
        Menu.add(menu);
    }

    public void makeCantEatMenu(String[] menuList){
        for(int i=0;i<menuList.length;i++){
            cantEatMenu.add(menuList[i]);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return Menu;
    }
}
