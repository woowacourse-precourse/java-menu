package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final String NAME_LENGTH_ERROR = "코치 이름은 2~4글자 이내여야 합니다.";
    private final String name;
    private final List<String> selectedMenus = new ArrayList<>();
    private final List<String> inedibleMenus = new ArrayList<>();

    public Coach(String name){
        validateCoachName(name.trim());
        this.name = name.trim();
    }

    private void validateCoachName(String name){
        if(name.length()<2 || name.length()>4){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void addSelectedMenus(List<String> menus){
        selectedMenus.addAll(menus);
    }

    public void addInedibleMenus(List<String> menus){
        inedibleMenus.addAll(menus);
    }

    public boolean isSelectedMenu(String menu){
        return selectedMenus.contains(menu);
    }

    public boolean isInedibleMenu(String menu){
        return inedibleMenus.contains(menu);
    }

    public String getName(){
        return name;
    }

}
