package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import menu.repository.MenuRepository;

public class Coach {

    String name;
    private final List<Menu> canNotEatMenu;

    public Coach(String name, List<String> canNotEatMenu) {
        validateName(name);
        validateMenu(canNotEatMenu);
        this.name = name;
        this.canNotEatMenu = mapToMenus(canNotEatMenu);
    }

    private void validateMenu(List<String> canNotEatMenu) {
        if(canNotEatMenu.size()>2){
            throw new IllegalArgumentException("코치가 못먹는 메뉴는 최대 2개입니다");
        }

    }

    private void validateName(String name) {
        if(name.length()<2 || name.length()>4){
            throw new IllegalArgumentException("코치 이름의 길이는 2글자 이상 4글자 이해합니다");
        }
    }

    private List<Menu> mapToMenus(List<String> canNotEatMenu) {
        List<Menu> menus = new ArrayList<>();
        if(canNotEatMenu.get(0).isBlank()){
            menus.add(MenuRepository.findByMenuName("BLANK"));
            return menus;
        }
        for (String notEatMenu : canNotEatMenu) {
            Menu menu = MenuRepository.findByMenuName(notEatMenu);
            menus.add(menu);
        }
        return menus;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getCanNotEatMenu() {
        return Collections.unmodifiableList(canNotEatMenu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) && Objects.equals(canNotEatMenu,
            coach.canNotEatMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, canNotEatMenu);
    }
}
