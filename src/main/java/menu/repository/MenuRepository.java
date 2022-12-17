package menu.repository;

import menu.model.Coach;
import menu.model.Menu;
import menu.util.IllegalArgumentExceptionMessage;

import java.util.ArrayList;
import java.util.List;

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
                        -> new IllegalArgumentException(IllegalArgumentExceptionMessage.NO_MATCHING_MENU.getMessage()));
    }
}
