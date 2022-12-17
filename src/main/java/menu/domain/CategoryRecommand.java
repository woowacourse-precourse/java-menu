package menu.domain;

import java.util.HashMap;
import java.util.List;

public class CategoryRecommand {

    HashMap<String, Integer> categoryCount;

    public CategoryRecommand(HashMap<String, Integer> categoryCount){
        this.categoryCount = categoryCount;
    }
}
