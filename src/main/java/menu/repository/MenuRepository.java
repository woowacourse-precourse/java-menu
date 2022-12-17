package menu.repository;

import menu.model.Coach;
import menu.model.Menu;
import menu.model.MenuCategory;
import menu.util.IllegalArgumentExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuRepository {
    private static MenuRepository menuRepository;
    private final List<Menu> menus;

    private MenuRepository() {
        this.menus = new ArrayList<>();
    }

    // 싱글톤 패턴 적용 -> 데이터를 메모리상에 저장하기 위해 사용
    public static MenuRepository getInstance() {
        if(menuRepository == null) {
            synchronized(MenuRepository.class)
            {
                menuRepository = new MenuRepository();
            }
        }
        return menuRepository;
    }

    public Menu findByName(String name) {
       return menus.stream().filter(menu
                -> menu.getName().equals(name))
                .findFirst()
                .orElseThrow(()
                        -> new IllegalArgumentException( name + IllegalArgumentExceptionMessage.NO_MATCHING_MENU.getMessage()));
    }

    public List<Menu> findByCategory(MenuCategory menuCategory) {
        return menus.stream().filter(menu -> menu.getMenuCategory().equals(menuCategory)).collect(Collectors.toList());
    }

    public void save(Menu menu) {
        menus.add(menu);
    }
}
