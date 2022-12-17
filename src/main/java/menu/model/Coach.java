package menu.model;

import menu.util.ErrorMessage;

import java.util.*;

public class Coach {

    private String name;
    private List<Menu> nonMenus;

    private Map<Category,Integer> eatCategory;
    private List<Menu> eatMenu;

    public Coach(String name) {
        validateNameSize(name);
        this.name = name;
        eatCategory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setNonMenus(List<Menu> nonMenus) {
        this.nonMenus = nonMenus;
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
