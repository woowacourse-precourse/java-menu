package menu.dto.request;

import java.util.List;

public class HateMenuDto {

    private final static int HATE_MENU_MAX_SIZE = 2;

    private final List<String> hateMenus;

    public HateMenuDto(List<String> hateMenus) {
        validate(hateMenus);
        this.hateMenus = hateMenus;
    }

    private void validate(List<String> hateMenus) {
        if (hateMenus.size() > HATE_MENU_MAX_SIZE) {
            throw new IllegalArgumentException("코치가 못먹는 메뉴는 최대 2개입니다. 추가할려는 메뉴 갯수  : " +
                    hateMenus.size());
        }

        if (hateMenus.stream().distinct().count() != hateMenus.size()) {
            throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
        }
    }

    public List<String> getHateMenus() {
        return hateMenus;
    }
}
