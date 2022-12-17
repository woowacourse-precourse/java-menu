package menu.domain;

import java.util.List;

public class Day {

    String day;
    List<Category> categories;

    public Day(String day, List<Category>categories){
        this.day = day;
        this.categories = categories;
    }

    public boolean haveMenu(String menu) {
        for(Category category : categories){
            if(category.haveMenu(menu)){
                return true;
            }
        }
        return false;
    }

    public Category getCategory(int number) {
        for (int index = 1; index < number + 1; index++) {
            if (index == number) {
                return categories.get(index-1);
            }
        }
        return null;
    }

    public String getDay() {
        return day;
    }
}
