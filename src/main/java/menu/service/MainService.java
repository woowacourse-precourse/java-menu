package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
    private Coaches coaches;

    public void generateCoaches(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        this.coaches = new Coaches(coaches);
    }
}