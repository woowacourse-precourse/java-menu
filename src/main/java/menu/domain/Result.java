package menu.domain;

import java.util.List;
import java.util.Map;

public class Result {
    private List<String> selectedCategory;
    private Map<String, Integer> categoryCounts;

    public Result(List<String> selectedCategory, Map<String, Integer> categoryCounts) {
        this.selectedCategory = selectedCategory;
        this.categoryCounts = categoryCounts;
    }
}
