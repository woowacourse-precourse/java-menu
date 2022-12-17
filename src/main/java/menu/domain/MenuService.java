package menu.domain;

import java.util.List;
import java.util.Map;
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

    //TODO:구현 해야함
    public Map<Coach, RecommendResult> recommendMenu() {
        MenuRecommender menuRecommender = new MenuRecommender(new RandomShuffler());
        menuRecommender.recommend(new RandomNumberGenerator(), group);
        return menuRecommender.getResult();
    }
}
