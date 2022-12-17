package menu.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {

    private static final List<Coach> coaches = new ArrayList<>();

    public static List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public static void listToCoaches(List<String> inputs) {
        validCoaches(inputs);
        for (String name : inputs) {
            addCoach(new Coach(name));
        }
        coaches.stream().forEachOrdered(it -> System.out.println(it.getName()));
    }

    private static void validCoaches(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치 맴버는 2명 ~ 5명을 입력해야 합니다.");
        }
    }

    public static void inputHateFood(String name, List<String> inputs) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(name)) {
                coach.inputHateFoods(inputs);
            }
        }
    }
}
