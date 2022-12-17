package menu;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String[] getCoachList() {
        try {
            String[] coaches = Console.readLine().split(",");
            InputException.coachListCheck(coaches);
            InputException.coachNameCheck(coaches);
            return coaches;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCoachList();
        }
    }

    public static String[] getHateMenus() {
        try {
            String[] hateMenus = Console.readLine().split(",");
            InputException.hateMenusNumCheck(hateMenus);
            return hateMenus;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getHateMenus();
        }
    }
}
