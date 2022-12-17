package menu;

import menu.Util.CategoryAndFood;

import java.util.HashMap;
import java.util.List;

public class Recommander {
    private HashMap<String, List<String>> database;
    private List<String> category;
    private CategoryAndFood categoryAndFood;
    private int[] categoryCount;

    public Recommander() {
        this.categoryAndFood = new CategoryAndFood();
        this.database = categoryAndFood.getDataBase();
        this.category = categoryAndFood.getCategoryList();
        this.categoryCount = new int[6];
    }

    public void run() {

    }
}
