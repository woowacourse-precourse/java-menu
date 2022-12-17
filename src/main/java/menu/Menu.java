package menu;

import java.util.List;

public class Menu {
    String category;
    List<String> food;
    Menu(String category, List<String> food){
        this.category = category;
        this.food = food;
    }
}
