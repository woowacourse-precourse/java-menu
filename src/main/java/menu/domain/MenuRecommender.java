package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuRecommender {
    private List<Category> categoryHistory = new ArrayList<>();
    private List<String> coaches = new ArrayList<>();
    private static final List<Category> CATEGORIES = Arrays.asList(Category.values());
}
