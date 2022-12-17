package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final static int NAME_MAX_LENGTH = 4;
    private final static int NAME_MIN_LENGTH = 2;

    private final String name;
    private final List<Menu> hateMenus = new ArrayList<>();

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
        hateMenus.addAll(menus);
        if (hateMenus.size() > 2) {
            throw new IllegalArgumentException("코치가 못먹는 메뉴는 최대 2개입니다. 현재 못먹는 메뉴 갯수  : " + hateMenus.size());
        }
    }

    public String getName() {
        return name;
    }
}
