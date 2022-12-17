package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.util.Categori;
import menu.util.CategoriCode;
import menu.util.DayStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaysRecommand {
    private List<Day> days;
    private List<String> categoriList;

    DaysRecommand(List<Day> days) {
        this.days = days;
        this.categoriList = new ArrayList<>();
    }

    public static DaysRecommand of() {
        return new DaysRecommand(initDays());
    }

    public static List<Day> initDays() {
        List<Day> days = new ArrayList<>();
        for (DayStatus dayStatus : DayStatus.values()) {
            days.add(Day.of(dayStatus.getDay()));
        }
        return days;
    }

    public List<Day> getDays() {
        return days;
    }

    public void initCoachNames(Coachs coachs) {
        for (Day day : days) {
            day.initCoachs(coachs);
        }
    }

    public void setDayCategori(String categoriName) {
        categoriList.add(categoriName);
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


}
