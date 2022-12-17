package menu;

import java.util.ArrayList;
import java.util.List;
import menu.ui.InputView;

public class Coach {

    private final String name;
    private List<String> allergicMenus = new ArrayList<>();

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
}
