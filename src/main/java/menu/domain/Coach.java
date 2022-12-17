package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final static int NAME_MAX_LENGTH = 4;
    private final static int NAME_MIN_LENGTH = 2;

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();
    private final List<Menu> lunchMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다. 입력값 : " + name);
        }
    }

    public void addHateMenus(List<Menu> menus) {
        if (menus.size() + hateMenus.size() > 2) {
            throw new IllegalArgumentException("코치가 못먹는 메뉴는 최대 2개입니다. 추가할려는 메뉴 갯수  : " + menus.size());
        }

        if (menus.stream().distinct().count() != menus.size()) {
            throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
        }
        hateMenus.addAll(menus);
    }

    public boolean isHateMenu(Menu menu) {
        return hateMenus.contains(menu);
    }

    public boolean duplicateLunchMenu(Menu menu) {
        return lunchMenus.contains(menu);
    }

    public void addLunchMenu(Menu menu) {
        lunchMenus.add(menu);
    }

    public List<Menu> getLunchMenus() {
        return lunchMenus;
    }

    public String getName() {
        return name;
    }
}
