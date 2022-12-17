package menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.coach.Coach;
import menu.utils.Constants;

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
            stringBuilder.append(Constants.PREFIX);
            stringBuilder.append(coach.getName());
            stringBuilder.append(Constants.DELIMITER);
            foodAppend(stringBuilder, coach);
        }
        return stringBuilder.toString();
    }

    private void foodAppend(StringBuilder stringBuilder, Coach coach) {
        List<String> foods = lunchSuggestion.get(coach);
        for (int i = 0; i < foods.size(); i++) {
            stringBuilder.append(foods.get(i));
            if (i != foods.size() - 1) {
                stringBuilder.append(Constants.DELIMITER);
            }
        }
        stringBuilder.append(Constants.POSTFIX + "\n");
    }

    public boolean sameFoodInWeek(Coach coach, String food) {
        return lunchSuggestion.get(coach).contains(food);
    }
}
