package menu;

import menu.domain.Coach;
import menu.domain.WeekMenus;
import menu.domain.Menu;
import menu.enums.Category;
import menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MenuRecommendService {

    public List<WeekMenus> recommendMenus(List<Coach> coaches, List<Category> weekCategories) {
        //못 먹는 음식 고려
        //한 주에 먹었던 음식 또 안됨
        List<WeekMenus> weekMenus = new ArrayList<>();

        for (Coach coach : coaches) {
            List<Menu> coachMenu = pickMenusInCategory(weekCategories, coach);
            weekMenus.add(new WeekMenus(coach, coachMenu));
        }
        return weekMenus;
    }

    private List<Menu> pickMenusInCategory(List<Category> categories, Coach coach) {
        List<Menu> coachMenu = new ArrayList<>();

        for (Category category : categories) {
            String menuName = shuffle(MenuRepository.getMenusByCategory(category)).get(0);
            if ((isAlreadyExist(coachMenu, menuName)) || coach.isExcludeMenu(menuName)) {
                menuName = shuffle(MenuRepository.getMenusByCategory(category)).get(0);
            }
            coachMenu.add(new Menu(category, menuName));

        }
        return coachMenu;
    }

    private boolean isAlreadyExist(List<Menu> coachMenu, String menuName) {
        return coachMenu.stream().anyMatch(m -> m.isSameMenu(menuName));
    }
}
