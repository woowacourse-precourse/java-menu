package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachDto;
import menu.dto.CoachNamesDto;

public class MenuService {
    private Group group;

    public void initialCoachesNames(CoachNamesDto coachNamesDto) {
        List<String> names = coachNamesDto.getNames();
        List<Coach> coaches = names.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        group = new Group(coaches);
    }

    public void initialCoachCantEatMenus(CoachDto coach) {
        group.addCoachCantEatMenus(coach);
    }

    public CoachNamesDto getCoachesNames() {
        return group.toCoachNamesDto();
    }
}
