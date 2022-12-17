package menu.model;

import menu.constant.Category;
import menu.constant.Day;

public class Menu {
    Category category;
    Day day;
    String menuName;

    public Menu(Day day, Category category, String menuName){
        this.day = day;
        this.category = category;
        this.menuName = menuName;
    }

    public String getMenuName(){
        return menuName;
    }


}
