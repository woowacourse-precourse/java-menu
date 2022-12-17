package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public List<String> readCoachNames() {
        String names = Console.readLine();
        Validator.checkCoachNames(names);
        System.out.println();
        return Arrays.asList(names.split(","));
    }

    public List<String> readHatingMenus() {
        String menus = Console.readLine();
        if (menus.equals("")) {
            System.out.println();
            return new ArrayList<>();
        }
        if (!menus.contains(",")) {
            Validator.checkExistMenu(menus);
            List<String> hatings = new ArrayList<>();
            hatings.add(menus);
            System.out.println();
            return hatings;
        }
        Validator.checkHatingMenus(menus);
        System.out.println();
        return Arrays.asList(menus.split(","));
    }
}
