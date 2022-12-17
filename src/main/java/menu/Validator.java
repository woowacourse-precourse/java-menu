package menu;

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

    public static void notPreferMenuCheck() {

    }

    public static boolean recommendMenuCheck(String menuName, Coach coach) {
        if (coach.getNotPreferMenu().contains(menuName))
            return true;
        return false;
    }
}
