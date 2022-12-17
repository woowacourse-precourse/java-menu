package menu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class Coach {
    private final String name;
    private final List<Menu> hateMenus;

    public Coach(String name, List<Menu> hateMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
    }
}
