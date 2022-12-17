package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String COMMA = ",";

    private static final String BLANK = "";

    public List<String> readCoachNames() {
        String names = Console.readLine();
        Validator.checkCoachNames(names);
        System.out.println();
        return Arrays.asList(names.split(COMMA));
    }

    public List<String> readHatingMenus() {
        String menus = Console.readLine();
        System.out.println();
        if (menus.equals(BLANK)) {
            return new ArrayList<>();
        }
        if (!menus.contains(COMMA)) {
            Validator.checkExistMenu(menus);
            return getAloneMenuList(menus);
        }
        Validator.checkHatingMenus(menus);
        return Arrays.asList(menus.split(COMMA));
    }

    private List<String> getAloneMenuList(String menus) {
        List<String> hatings = new ArrayList<>();
        hatings.add(menus);
        return hatings;
    }
}
