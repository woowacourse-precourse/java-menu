package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.repository.CoachesRepository;

public class MenuService {
    public Coaches saveCoach(final List<String> validatedCoach) {
        return CoachesRepository.save(validatedCoach.stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }
}
