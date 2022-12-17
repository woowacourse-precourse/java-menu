package menu.domain;

import menu.utills.Recommender;
import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    // TODO: refactoring indent, line
    public void takeRecommendByCategories(List<Category> categories) {
        for (Category category : categories) {
            for (Coach coach : coaches) {
                Menu randomMenu = Recommender.getRandomMenu(category);
                while (coach.unAcceptable(randomMenu)) {
                    randomMenu = Recommender.getRandomMenu(category);
                }
                coach.addRecommendedMenu(randomMenu);
            }
        }
    }

    public List<String> getRecommendedResult() {
        return coaches.stream()
                .map(Coach::getRecommendedMenuNames)
                .collect(Collectors.toList());
    }
}

