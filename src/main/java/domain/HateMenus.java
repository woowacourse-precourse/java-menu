package domain;

import java.util.List;

public class HateMenus {

    private final List<Menu> hateMenusName;

    public HateMenus(List<Menu> hateMenusName) {
        validateHateMenusNameCount(hateMenusName);
        this.hateMenusName = hateMenusName;
    }

    private void validateHateMenusNameCount(List<Menu> hateMenusName) {
        if (hateMenusName.size() <= 2) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최소 0개 이상, 최대 2개 이하로 입력해주세요.");
    }

    public List<Menu> getHateMenusName() {
        return hateMenusName;
    }

    public boolean isContainHateMenu(Menu menu) {
        return hateMenusName.contains(menu);
    }
}
