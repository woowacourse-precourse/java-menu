package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {

    private final static List<Menu> menus = new ArrayList<>();

    private MenuRepository(){}

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

    // 매번 stream 말고 다른 방법은?
    public List<Menu> findAllByCategory(Category category){
        return menus.stream()
                .filter(e -> e.getCategory() == category)
                .collect(Collectors.toList());
    }

}
