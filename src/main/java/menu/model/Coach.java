package menu.model;

import menu.util.ErrorMessage;

import java.util.List;
import java.util.Objects;

public class Coach {

    private String name;

    private List<Menu> menus;

    public Coach(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;

        Coach coach = (Coach) o;

        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
