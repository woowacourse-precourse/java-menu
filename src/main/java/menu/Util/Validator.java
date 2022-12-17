package menu.Util;

import menu.Model.Coach;
import menu.Model.DayMenu;
import menu.Model.WeekMenu;

import java.util.List;

public class Validator {

    public static boolean recommendCategoryCheck(WeekMenu weekMenu, String input) {
        int count = 0;
        for (DayMenu e : weekMenu.getWeekMenu()) {
            if (e.getCategory() != null && e.getCategory().equals(input))
                count++;
            if (count > 2)
                return true;
        }
        return false;
    }

    public static List<String> notPreferMenuCheck(String input) {
        List<String> notPreferMenus = List.of(input.split(","));
        if (notPreferMenus.size() < 0 || notPreferMenus.size() > 2)
            throw new IllegalArgumentException("[ERROR] 잘못된 개수입니다.");
        return notPreferMenus;
    }

    public static List<String> coachNameCheck(String input) {
        List<String> coachNames = List.of(input.split(","));
        if (coachNames.size() == 0)
            throw new IllegalStateException("[ERROR] 입력되지 않았습니다.");
        if (coachNames.size() < 2 || coachNames.size() > 5)
            throw new IllegalArgumentException("[ERROR] 잘못된 인원입니다.");
        for (String coachName : coachNames)
            if (coachName.length() < 2 || coachName.length() > 4)
                throw new IllegalArgumentException("[ERROR] 잘못된 이름입니다.");
        return coachNames;
    }

    public static boolean recommendMenuCheck(String menuName, Coach coach) {
        if (coach.getNotPreferMenu().contains(menuName))
            return true;
        return false;
    }
}
