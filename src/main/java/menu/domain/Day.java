package menu.domain;

import java.util.List;

public class Day {

    String day;
    List<Category> categories;

    public Day(String day, List<Category>categories){
        this.day = day;
        this.categories = categories;
    }

    public Menu findMenu(String menu) {
        for(Category category : categories){
            return category.findMenu(menu);
        }
        return null;
    }

    public boolean haveMenu(String menu) {
        for(Category category : categories){
            if(category.haveMenu(menu)){
                return true;
            }
        }
        return false;
    }
}
