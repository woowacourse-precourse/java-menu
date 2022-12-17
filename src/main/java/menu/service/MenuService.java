package menu.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;

public class MenuService {

    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public MenuService(MenuRepository menuRepository, CoachRepository coachRepository) {
        this.menuRepository = menuRepository;
        this.coachRepository = coachRepository;
    }

    public void saveCoach(String coachNames) {
        List<Coach> coaches = Arrays.stream(coachNames.split(",", -1))
                .map(Coach::new)
                .collect(Collectors.toList());
        coachRepository.saveAll(coaches);
    }
}
