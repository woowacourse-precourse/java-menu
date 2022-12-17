package menu.domain;

public class Coach {

    private final String name;
    private Menus couldNotEatMenus;

    public Coach(String name, Menus CouldNotEatMenus) {
        if(!isValidName(name)){
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
        if(!isValidMenuSize(couldNotEatMenus)){
            throw new IllegalArgumentException("코치가 못 먹는 메뉴의 개수는 최소 0개, 최대 2개입니다.");
        }
        this.name = name;
        this.couldNotEatMenus = CouldNotEatMenus;
    }

    private static boolean isValidName(String name) {
        return 2 <= name.length() && name.length() <= 4;
    }

    private boolean isValidMenuSize(Menus couldNotEatMenus) {
        return couldNotEatMenus.size() <= 2;
    }
}
