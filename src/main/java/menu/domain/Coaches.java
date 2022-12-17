package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.utils.validator.CoachesValidator;

public class Coaches {

    private final List<Coach> coaches = new ArrayList<>();

    private List<String> categories = new ArrayList<>();

    public Coaches(List<String> coachNames) {
        new CoachesValidator(coachNames);
        coachNames.stream().forEach(
            coachName -> coaches.add(new Coach(coachName.toString()))
        );
    }

    public void addCategories(Category category){
        this.categories.add(category.getCategory());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getCategories() {
        return categories;
    }
}
