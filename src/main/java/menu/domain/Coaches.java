package menu.domain;

import static menu.domain.constant.MenuRule.MAXIMUM_COACH_COUNT;
import static menu.domain.constant.MenuRule.MAXIMUM_COACH_NAME_LENGTH;
import static menu.domain.constant.MenuRule.MINIMUM_COACH_COUNT;
import static menu.domain.constant.MenuRule.MINIMUM_COACH_NAME_LENGTH;

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
        validateCoachesLength(coachNames);
        validateCoachNames(coachNames);
        coachNames.forEach(name -> {
            coaches.add(new Coach(name));
        });
    }

    private void validateCoachNames(List<String> coachNames) {
        coachNames.forEach(this::validateCoachName);
    }

    private void validateCoachName(String name) {
        if (MINIMUM_COACH_NAME_LENGTH <= name.length() && name.length() <= MAXIMUM_COACH_NAME_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "[ERROR] 코치 이름은 %d자 이상 %d자 이하여야 합니다.", MINIMUM_COACH_NAME_LENGTH, MAXIMUM_COACH_NAME_LENGTH
        ));
    }

    private void validateCoachesLength(List<String> coachNames) {
        if (MINIMUM_COACH_COUNT <= coachNames.size() && coachNames.size() <= MAXIMUM_COACH_COUNT) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                "[ERROR] %d명 이상 %d명 이하의 코치들이 밥을 함께 먹어야 합니다.", MINIMUM_COACH_COUNT, MAXIMUM_COACH_COUNT
        ));
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void registerInedibleMenusToCoach(String coachName, List<String> inedibleMenus) {
        Coach coachToAddInedibleMenus = getCoachByName(coachName);
        coachToAddInedibleMenus.registerInedibleMenus(inedibleMenus);
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
        coaches.forEach(coach -> coachMenus.add(coach.getCoachMenu()));
        return coachMenus;
    }
}
