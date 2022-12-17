package menu;

import menu.domain.Coach;
import menu.domain.WeekMenus;
import menu.domain.Menu;
import menu.enums.Category;
import menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MenuRecommendService {

    public List<WeekMenus> recommendMenus(List<Coach> coaches, List<Category> weekCategories) {
        List<WeekMenus> weekMenus = new ArrayList<>();
        Map<Coach, List<Menu>> coachMenu = new HashMap<>();

        for (Category category : weekCategories) {
            for (Coach coach : coaches) {
                pickMenusInCategory(coachMenu, category, coach);
            }
        }

        for (Map.Entry<Coach, List<Menu>> menus : coachMenu.entrySet()) {
            weekMenus.add(new WeekMenus(menus.getKey(), menus.getValue()));
        }

        return weekMenus;
    }

    private void pickMenusInCategory(Map<Coach, List<Menu>> coachMenu, Category category, Coach coach) {
        String menuName = shuffle(MenuRepository.getMenusByCategory(category)).get(0);
        if ((isAlreadyExist(coachMenu, coach, menuName)) || coach.isExcludeMenu(menuName)) {
            menuName = shuffle(MenuRepository.getMenusByCategory(category)).get(0);
        }
        List<Menu> toAdd = coachMenu.getOrDefault(coach, new ArrayList<>());
        toAdd.add(new Menu(category, menuName));
        coachMenu.put(coach, toAdd);
    }

    private boolean isAlreadyExist(Map<Coach, List<Menu>> coachMenu, Coach coach, String menuName) {
        return coachMenu.getOrDefault(coach, new ArrayList<>()).stream().anyMatch(menu -> menu.isSameMenu(menuName));
    }
}
