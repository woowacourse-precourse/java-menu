package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachDto;
import menu.dto.CoachNamesDto;

public class Group {
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;
    private static final String INVALID_GROUP_SIZE = "함께 식사하는 코치의 수는 2~5명입니다.";
    private final List<Coach> group;

    public Group(List<Coach> group) {
        validate(group);
        this.group = group;
    }

    private void validate(List<Coach> group) {
        if (group.size() < MIN_SIZE || group.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_GROUP_SIZE);
        }
    }

    public CoachNamesDto toCoachNamesDto() {
        List<String> names = group.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
        return new CoachNamesDto(names);
    }

    public void addCoachCantEatMenus(CoachDto coachDto) {
        String name = coachDto.getName();
        Coach coach = group.stream()
                .filter(c -> c.isSameName(name))
                .findFirst()
                .get();
        coach.addCantEatMenus(coachDto.getCantEatMenus());
    }

    public List<RecommendResult> selectMenu(Shuffler shuffler, List<String> menuNames) {
        List<RecommendResult> results = new ArrayList<>();
        for (Coach coach : group) {
            List<Menu> menus = coach.exceptCantEatMenus(menuNames);
            Menu recommendedMenu = menus.get(0);
            results.add(new RecommendResult(coach, recommendedMenu));
        }
        return results;
    }
}
