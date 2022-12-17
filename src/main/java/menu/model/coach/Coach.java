package menu.model.coach;

import menu.model.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final int MAX_NAME_SIZE = 4;
    private static final int MIN_NAME_SIZE = 2;

    private final String name;
    private final List<Menu> hatingMenuList;

    public Coach(String name) {
        validate(name);

        this.name = name;
        this.hatingMenuList = new ArrayList<>();
    }

    public String getName() {
        // TODO 구현 필요

        return "";
    }

    public List<Menu> getHatingMenuList() {
        // TODO 구현 필요

        return new ArrayList<>();
    }

    public void addHatingMenu(Menu hatingMenu) {

    }

    private void validate(String str) {
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

    private boolean hasComma(String str) {
        return str.contains(",");
    }

    private boolean doesExceedMaxLimitSize(String str) {
        return str.length() > MAX_NAME_SIZE;
    }

    private boolean doesNotExceedMinLimitSize(String str) {
        return str.length() < MIN_NAME_SIZE;
    }
}
