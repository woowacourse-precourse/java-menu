package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.domain.menu.Menu;
import menu.util.Categori;
import menu.util.CategoriCode;
import menu.util.DayStatus;
import menu.util.MenuStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaysRecommand {
    private Map<String, Day> days;
    private List<String> categoriList;

    DaysRecommand(Map<String, Day> days) {
        this.days = days;
        this.categoriList = new ArrayList<>();
    }

    public static DaysRecommand of() {
        return new DaysRecommand(initDays());
    }
    public static Map<String, Day> initDays() {
        Map<String, Day> days = new HashMap<>();
        for (DayStatus dayStatus : DayStatus.values()) {
            days.put(dayStatus.getDay(), Day.of(dayStatus.getDay()));
        }
        return days;
    }

    public Map<String, Day> getDays() {
        return days;
    }

    public List<String> getCategoriList() {
        return categoriList;
    }

    public void initCoachNames(Coachs coachs) {
        for (DayStatus dayStatus : DayStatus.values()) {
            days.get(dayStatus.getDay()).initCoachs(coachs);
        }
    }

    public void setDayCategori(String categoriName) {
        categoriList.add(categoriName);
    }

    public String getCategoriName() {
        return categoriList.get(categoriList.size()-1);
    }

    public boolean isCategoriMax(String categoriName) {
        if (CategoriCode.MAX_DUPLICATE.getCode() < countCategoriName(categoriName)) {
            return false;
        }
        return true;
    }

    public int countCategoriName(String categoriName) {
        int count = 0;
        for (String name : categoriList) {
            if (name == categoriName) {
                count++;
            }
        }
        return count;
    }

    public void setDayMenu(Coach coach, Menu menu, String dayName) {
        boolean eat = true;
        String menuName = MenuStatus.NOT_EAT.getMenu();
        while (eat) {
            menuName = days.get(dayName).getCoachsMenu(menu, getCategoriName());
            eat = isAlreadyEat(coach, menuName);
            eat = isHate(coach, menuName);
        }
        days.get(dayName).setCoachsMenu(coach, menuName);
    }

    public boolean isAlreadyEat(Coach coach, String menuName) {
        for (DayStatus dayStatus : DayStatus.values()) {
            Map<Coach, String> day =  days.get(dayStatus.getDay()).getCoachMenu();
            if (isEat(menuName, day.get(coach))) {
                return true;
            }
        }
        return false;
    }

    public boolean isEat(String menuName, String coachEat) {
        if (menuName.equals(coachEat)) {
            return true;
        }
        return false;
    }

    public boolean isHate(Coach coach, String menuName) {
        if (coach.getFoods().contains(menuName)) {
            return true;
        }
        return false;
    }
}
