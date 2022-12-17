package menu.model.coach;

import menu.model.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final int MAX_NAME_SIZE = 4;
    private static final int MIN_NAME_SIZE = 2;

    private static final int MAX_HATING_MENU_LIST_SIZE = 2;

    private final String name;
    private final List<Menu> hatingMenuList;

    public Coach(String name) {
        validateName(name);

        this.name = name;
        this.hatingMenuList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Menu> getHatingMenuList() {
        return new ArrayList<>(hatingMenuList);
    }

    public void addHatingMenu(Menu hatingMenu) {
        validateNewHatingMenu(hatingMenu);
        hatingMenuList.add(hatingMenu);
    }

    private void validateName(String str) {
        if(hasComma(str)) {
            throw new IllegalArgumentException("이름에 ,가 들어갈 수 없습니다.");
        }
        if (doesExceedMaxLimitSize(str)) {
            throw new IllegalArgumentException("이름은 최대 4글자입니다.");
        }
        if (doesNotExceedMinLimitSize(str)) {
            throw new IllegalArgumentException("이름은 최소 2글자입니다.");
        }
    }

    private void validateNewHatingMenu(Menu newHatingMenu) {
        if (doesHatingMenuTouchLimit()) {
            throw new IllegalStateException("기피 메뉴는 최대 2개까지 가능합니다.");
        }
        if (hasDuplicateHatingMenu(newHatingMenu)) {
            throw new IllegalStateException("동일한 기피 메뉴는 등록할 수 없습니다.");
        }
    }

    private boolean hasComma(String str) {
        return str.contains(",");
    }

    private boolean doesExceedMaxLimitSize(String str) {
        return str.length() > MAX_NAME_SIZE;
    }

    private boolean doesNotExceedMinLimitSize(String str) {
        return str.length() < MIN_NAME_SIZE;
    }

    private boolean doesHatingMenuTouchLimit() {
        return hatingMenuList.size() == MAX_HATING_MENU_LIST_SIZE;
    }

    private boolean hasDuplicateHatingMenu(Menu newHatingMenu) {
        return hatingMenuList.contains(newHatingMenu);
    }
}
