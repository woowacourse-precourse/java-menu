package menu.domain;

import menu.domain.coach.Coach;
import menu.domain.coach.Coachs;
import menu.util.Categori;
import menu.util.DayStatus;
import menu.util.PrintMsg;

import java.util.*;

public class Result {
    private List<String> division;
    private List<String> categori;
    private Map<String, List<String>> coachMap;
    private List<String> coachResult;

    Result() {
        division = new ArrayList<>();
        categori = new ArrayList<>();
        coachMap = new HashMap<>();
        coachResult = new ArrayList<>();
        initResult();
    }

    public static Result of() {
        return new Result();
    }

    private void initResult() {
        division.add(PrintMsg.DIVISION.getMsg());
        division.addAll(DayStatus.getDays());
        categori.add(PrintMsg.CATEGORI.getMsg());
        categori.addAll(Categori.getCategoriNames());
    }

    public void initCoach(Coachs coachs) {
        for (Coach coach : coachs.getCoachs()) {
            coachMap.put(coach.getName(), new ArrayList<>());
        }
    }

    public void setRecommand(DaysRecommand daysRecommand, Coachs coachs) {
        for (DayStatus dayStatus : DayStatus.values()) {
            addFoodEachDay(daysRecommand.getDays().get(dayStatus.getDay()));
        }
        mapToString(coachs);
    }

    public void addFoodEachDay(Day day) {
        Map<Coach, String> coachMenu = day.getCoachMenu();
        for (Coach coach : coachMenu.keySet()) {
            coachMap.get(coach.getName()).add(coachMenu.get(coach));
        }
    }

    public void mapToString(Coachs coachs) {
        for (Coach coach : coachs.getCoachs()) {
            coachResult.add(getCoachMenu(coach));
        }
    }
    public String getCoachMenu(Coach coach) {
        StringJoiner stringJoiner = getFormat();
        List<String> coachMenu = coachMap.get(coach.getName());
        for (String menu : coachMenu) {
            stringJoiner.add(menu);
        }
        return stringJoiner.toString();
    }

    public StringJoiner getFormat() {
        return new StringJoiner(PrintMsg.DIVIDE.getMsg()
                , PrintMsg.START_FIX.getMsg()
                , PrintMsg.END_FIX.getMsg());
    }

    public String divisionToString() {
        StringJoiner stringJoiner = getFormat();
        for (String divide : division) {
            stringJoiner.add(divide);
        }
        return stringJoiner.toString();
    }

    public String categoriToString() {
        StringJoiner stringJoiner = getFormat();
        for (String categori : categori) {
            stringJoiner.add(categori);
        }
        return stringJoiner.toString();
    }

    public List<String> getCoachResult() {
        return coachResult;
    }
}
