package menu.domain;

import java.util.List;

public class Result {
    private List<String> selectedCategory;

    public Result(List<String> selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
