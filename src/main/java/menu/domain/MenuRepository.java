package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    private List<Menu> menus = new ArrayList<>();

    private static final MenuRepository instance = new MenuRepository();

    public static MenuRepository getInstance() {
        return instance;
    }

    public Menu save(Menu menu){
        menus.add(menu);
        return menu;
    }

    public List<Menu> findAll(){
        return new ArrayList<>(menus);
    }

}
