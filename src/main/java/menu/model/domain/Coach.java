package menu.model.domain;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
public class Coach {

    private String name;
    private List<String> hateMenus;

    public Coach(String name, List<String> hateMenus) {
        this.name = name;
        this.hateMenus = hateMenus;
    }

    public String getName() {
        return name;
    }

}
