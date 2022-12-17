package menu.domains;

import java.util.ArrayList;
import java.util.List;

public enum Categories {
    일식("일식"),
    한식("한식"),
    중식("중식"),
    아시안("아시안"),
    양식("양식");

    private String name;
    private List<String> menues;

    Categories(String name) {
        this.name = name;
        this.menues = new ArrayList<>();
    }

    public static void updateMenu(Categories category,List<String> categoryMenu){
        category.menues.addAll(categoryMenu);
    }

    public static List<String> getMenuList(Categories category){
        return category.menues;
    }

}
