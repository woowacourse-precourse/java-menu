package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.constant.Category;
import menu.domain.constant.Day;
import menu.domain.vo.CoachMenu;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public void addCoaches(List<String> coachNames) {
        coachNames.forEach(name -> {
            coaches.add(new Coach(name));
        });
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void registerInedibleFoodsToCoach(String coachName, List<String> inedibleFoods) {
        Coach coachToAddInedibleFoods = getCoachByName(coachName);
        coachToAddInedibleFoods.registerInedibleFoods(inedibleFoods);
    }

    private Coach getCoachByName(String coachName) {
        return coaches.stream()
                .filter(coach -> coach.isNameOf(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코치의 이름입니다."));
    }

    public void recommendMenuForEachCoach(Day day, Category categoryOfDay) {
        coaches.forEach(coach -> coach.recommendMenuOfDay(day, categoryOfDay));
    }

    public List<CoachMenu> getCoachMenus() {
        List<CoachMenu> coachMenus = new ArrayList<>();
        coaches.forEach(coach -> {
            coachMenus.add(coach.getCoachMenu());
        });
    }
}
