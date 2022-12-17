package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.generator.CategoryGenerator;

import java.util.HashMap;
import java.util.List;

public class MenuService {
    private CategoryGenerator categoryGenerator;
    private HashMap<Category, Integer> categoryCounter;
    private final List<Coach> coaches;

    public MenuService(List<Coach> coaches) {
        this.coaches = coaches;
        categoryGenerator = new CategoryGenerator();
        for(Category category : Category.values()){
            categoryCounter.put(category, 0);
        }
    }
    public void recommend(){
        Category category = getRandomCategory(categoryCounter);
        Integer count = categoryCounter.get(category);
        categoryCounter.put(category, count + 1);
    }

    public Category getRandomCategory(HashMap<Category, Integer> categoryCounter){
        return categoryGenerator.pick(categoryCounter);
    }
}
