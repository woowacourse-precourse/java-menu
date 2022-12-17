package menu.repository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;

public class CoachRepository {

    private static final List<Coach> repository = new ArrayList<>();

    public void saveAll(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(toList());
        repository.addAll(coaches);
    }

    public List<Coach> findAll() {
        return Collections.unmodifiableList(repository);
    }
}
