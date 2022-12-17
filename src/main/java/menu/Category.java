package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String categoryName;
    private final List<String> menuList;

    public Category(String categoryName, String menus){
        this.categoryName = categoryName;
        this.menuList = makeMenuList(menus.split(","));
    }

    public List<String> makeMenuList(String[] menus){
        List<String> menuList = new ArrayList<>();

        for(int i=0;i<menus.length;i++){
            menuList.add(menus[i]);
        }
        return menuList;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
