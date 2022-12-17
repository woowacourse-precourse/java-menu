package menu.repository;

import menu.domain.Coach;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coaches = new ArrayList<>();

    public void insertCoach(Coach coach) {
        coaches.add(coach);
    }

    public void updateCoach(Coach coach) {
        for(int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getName().equals(coach.getName())) {
                coaches.set(i,coach);
                break;
            }
        }
    }

    public List<Coach> findAll() {
        return coaches;
    }

    public Optional<Coach> selectCoachByName(String name) {
        return coaches.stream()
                .filter(coach -> coach.getName().equals(name))
                .findAny();
    }

    public void printAll() {
        coaches.forEach(coach -> {
            System.out.println("coach.getName() = " + coach.getName());
            System.out.println("coach.getName() = " + coach.getHateMenu());
        });
    }
}
