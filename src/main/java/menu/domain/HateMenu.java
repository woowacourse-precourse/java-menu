package menu.domain;

import java.util.List;

public class HateMenu {
    private static final int MAX_SIZE = 2;
    private static final String INVALID_SIZE_MESSAGE = String.format("못먹는 메뉴는 최대 %d개여야 합니다.", MAX_SIZE);

    private final List<Menu> hateMenus;

    public HateMenu(List<Menu> hateMenus) {
        validate(hateMenus);
        this.hateMenus = hateMenus;
    }

    private static void validate(List<Menu> hateMenus) {
        if(hateMenus.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    public boolean contains(Menu menu) {
        return hateMenus.contains(menu);
    }
}
