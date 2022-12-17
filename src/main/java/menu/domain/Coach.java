package menu.domain;

import java.util.*;

public class Coach {

    private final Map<String, List<String>> coaches;

    public Coach(String input) {
        this.coaches = new LinkedHashMap<>();
        makeCoach(input);
    }

    public List<String> getNames() {
        List<String> coachNames = new ArrayList<>();
        coachNames.addAll(coaches.keySet());

        return coachNames;
    }

    public void setCanNotEat(String name, String input) {
        List<String> foods = new ArrayList<>();

        String[] words = input.split(",");
        foods.addAll(Arrays.asList(words));

        coaches.put(name, foods);
    }

    private void makeCoach(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            coaches.put(name, new ArrayList<>());
        }
    }
}
