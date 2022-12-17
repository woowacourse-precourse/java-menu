package menu;

import java.util.List;

public class Menu {
    int categoryNum;
    String category;
    List<String> food;

    Menu(int categoryNum,String category, List<String> food){
        this.categoryNum = categoryNum;
        this.category = category;
        this.food = food;
    }
}
