package menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.coach.Coach;

public class LunchSuggestion {

    private final Map<Coach, List<String>> lunchSuggestion;

    public LunchSuggestion() {
        this.lunchSuggestion = new HashMap<>();

    }

    public void addSuggestion(Coach coach, String food) {
        List<String> foods = null;
        if (!lunchSuggestion.containsKey(coach)) {
            foods = new ArrayList<>();
            foods.add(food);
        }
        if (lunchSuggestion.containsKey(coach)) {
            foods = lunchSuggestion.get(coach);
            foods.add(food);
        }
        lunchSuggestion.put(coach, foods);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Coach coach : lunchSuggestion.keySet()) {
            stringBuilder.append("[ ");
            stringBuilder.append(coach.getName());
            stringBuilder.append(" | ");

            List<String> foods = lunchSuggestion.get(coach);
            for (int i = 0; i < foods.size(); i++) {
                stringBuilder.append(foods.get(i));
                if (i != foods.size() - 1) {
                    stringBuilder.append(" | ");
                }
            }
            stringBuilder.append(" ]\n");
        }
        return stringBuilder.toString();
    }

    public boolean sameFoodInWeek(Coach coach, String food) {
        return lunchSuggestion.get(coach).contains(food);
    }
}
