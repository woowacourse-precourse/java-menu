package menu.domain;

import java.util.List;

public class Category {

    String country;
    List<Menu> menus;

    public Category(String country, List<Menu>menus){
        this.country = country;
        this.menus = menus;
    }
}
