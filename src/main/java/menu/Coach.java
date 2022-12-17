package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import menu.ui.InputView;

public class Coach {

    private final String name;
    private Menus menus = new Menus();
    private List<String> allergicMenus = new ArrayList<>();
    private Stack<String> menuNameForEachDay = new Stack<>();
    private List<String> menusInventory = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void enterAllergicMenus() {
        List<String> allergicMenusOrigin = List.of((InputView.readAllergicMenus(name).split(",")));
        if(!isValidAllergicMenus(allergicMenusOrigin))
            throw new IllegalArgumentException("[ERROR] 먹지 못하는 음식의 입력이 정확하지 않습니다.");
        if(!isNoAllergicMenu(allergicMenusOrigin))
            this.allergicMenus = allergicMenusOrigin;
    }

    private boolean isNoAllergicMenu(List<String> allergicMenusOrigin) {
        if(allergicMenusOrigin.size() == 1 && allergicMenusOrigin.get(0).equals(""))
            return true;
        return false;
    }

    private boolean isValidAllergicMenus(List<String> allergicMenusOrigin) {
        if(allergicMenusOrigin.size() > 2)
            return false;
        return true;
    }


    public void selectMenus(Stack<String> menusForEachDay) {
        int dayCount = 0;
        while(dayCount < 5){
            List<String> menusByCategory = menus.getCategoryMenus(menusForEachDay.get(dayCount));
            String menuName = Randoms.shuffle(menusByCategory).get(0);
            if(!menusInventory.contains(menuName) && canEat(menuName)){
                menusInventory.add(menuName);
                menuNameForEachDay.add(menuName);
                dayCount++;
            }
        }
    }

    private boolean canEat(String menuName) {
        if(allergicMenus.contains(menuName))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public Stack<String> getMenuNameForEachDay() {
        return menuNameForEachDay;
    }
}
