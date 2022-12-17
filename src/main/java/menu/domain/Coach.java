package menu.domain;

import menu.utils.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MiN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private final List<String> menus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MiN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SATISFIED_NAME_LENGTH.get());
        }
    }

    public void addMenu(String menu) {
        menus.add(menu);
    }
}
