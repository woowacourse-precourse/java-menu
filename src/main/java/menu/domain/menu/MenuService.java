package menu.domain.menu;

import java.util.List;
import menu.domain.coach.Coach;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addCoachAvoidMenu(Coach coach, List<String> menuNames) {
        for (String menuName : menuNames) {
            Menu menu = menuRepository.findByMenuName(menuName);
            coach.addAvoidMenu(menu);
        }
    }
}
