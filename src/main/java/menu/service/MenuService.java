package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.MenuList;
import menu.generator.CategoryGenerator;
import menu.generator.MenuGenerator;

import java.util.HashMap;
import java.util.List;

public class MenuService {
    private CategoryGenerator categoryGenerator;
    private MenuGenerator menuGenerator;
    private HashMap<Category, Integer> categoryCounter;
    private final List<Coach> coaches;

    public MenuService(List<Coach> coaches) {
        this.coaches = coaches;
        categoryGenerator = new CategoryGenerator();
        menuGenerator = new MenuGenerator();
        for(Category category : Category.values()){
            categoryCounter.put(category, 0);
        }
    }
    public void recommend(){
        Category category = getRandomCategory(categoryCounter);
        Integer count = categoryCounter.get(category);
        categoryCounter.put(category, count + 1);
        for(Coach coach : coaches){
            List<String> menus = MenuList.getFiled(category);
            List<String> eatenMenu = coach.getEatenMenu();
            List<String> hateMenu = coach.getHateMenu();
            for(String menu : eatenMenu){
                menus.remove(menu);
            }
            for(String menu : hateMenu){
                menus.remove(menu);
            }
            coach.addEatenMenu(getRecommendMenu(menus));
        }
    }

    public Category getRandomCategory(HashMap<Category, Integer> categoryCounter){
        return categoryGenerator.pick(categoryCounter);
    }

    public String getRecommendMenu(List<String> menus){
        return menuGenerator.pick(menus);
    }
}
