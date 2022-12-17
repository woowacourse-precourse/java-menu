package menu.model;

import menu.constants.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;

    private final String name;
    private HateMenu hateMenu;
    private SelectMenu selectMenu;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public List<String> getSelectMenu() {
        List<String> temp = Collections.singletonList(name);
        List<String> selectMenuResult = new ArrayList<>();
        selectMenuResult.addAll(temp);
        selectMenuResult.addAll(selectMenu.getSelectMenu());
        return Collections.unmodifiableList(selectMenuResult);
    }

    public void addHateMenus(HateMenu hateMenu) {
        this.hateMenu = hateMenu;
    }
    public void addSelectMenu(SelectMenu selectMenu) {
        this.selectMenu = selectMenu;
    }

    public boolean isHateMenu(String menu) {
        return hateMenu.isHateMenu(menu);
    }

    private void validateName(String name) {
        if (isLessThanTwo(name.length())) {
            ExceptionMessage.NAME_LESS_THAN_TWO.throwException();
        }
        if (isMoreThanFour(name.length())) {
            ExceptionMessage.NAME_MORE_THAN_FOUR.throwException();
        }
    }

    private boolean isLessThanTwo(int length) {
        return length < MINIMUM_NAME_LENGTH;
    }

    private boolean isMoreThanFour(int length) {
        return MAXIMUM_NAME_LENGTH < length;
    }
}
