package menu.domains;

import java.util.ArrayList;
import java.util.List;

public enum Categories {
    JPN("일식"),
    KOR("한식"),
    CHN("중식"),
    ASN("아시안"),
    WES("양식");

    private String name;
    private List<String> menues;

    Categories(String name) {
        this.name = name;
        this.menues = new ArrayList<>();
    }

    public static void updateMenu(Categories category,List<String> categoryMenu){
        category.menues.addAll(categoryMenu);
    }

}
