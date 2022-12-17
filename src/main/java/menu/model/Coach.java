package menu.model;

import menu.util.ErrorMessage;

import java.util.List;

public class Coach {

    private String name;

    private List<Menu> menus;

    public Coach(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void validateNameSize(String name){
        if(isCorrectNameSize(name)){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NAME_SIZE_OVER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectNameSize(String name) {
        return name.length() >= 2 && name.length() <= 5;
    }
}
