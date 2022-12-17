package menu.domain;

import java.util.Collections;
import java.util.List;

public class MenuDTO {
    private final List<Coach> coaches;
    private final List<String> categories;

    public MenuDTO(List<Coach> coaches, List<String> categories) {
        this.coaches = Collections.unmodifiableList(coaches);
        this.categories = Collections.unmodifiableList(categories);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getCategories() {
        return categories;
    }
}
