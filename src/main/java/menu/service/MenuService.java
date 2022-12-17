package menu.service;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.repository.CoachesRepository;

public class MenuService {
    public void saveCoach(final List<String> validatedCoach) {
        CoachesRepository.save(validatedCoach.stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }
}
