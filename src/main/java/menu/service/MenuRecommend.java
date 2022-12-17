package menu.service;

import menu.domain.Coach;
import menu.domain.Group;
import menu.domain.Menu;
import menu.domain.enums.Category;
import menu.usecase.MenuRecommendUseCase;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MenuRecommend implements MenuRecommendUseCase {

    private static final int FIRST_SELECT_MENU_INDEX = 0;

    /**
     * 요일별로 반복하여 코치별로 메뉴 추천
     */
    @Override
    public void command(final Command command) {
        Group group = command.group();

        for (Category categoryForDay : group.categories()) {
            recommendByCategory(categoryForDay, group);
        }
    }

    private void recommendByCategory(final Category category,
                                     final Group group) {
        for (Coach coach : group.coaches()) {
            recommendForCoachByCategory(coach, category);
        }
    }

    private void recommendForCoachByCategory(final Coach coach,
                                             final Category category) {
        Menu menu = selectMenuForCoach(coach, category);
        coach.addRecommendedMenus(menu);
    }

    private Menu selectMenuForCoach(final Coach coach,
                                    final Category category) {
        List<String> menuNames = category.menuNames();
        Menu menu;
        do {
            String menuName = shuffle(menuNames).get(FIRST_SELECT_MENU_INDEX);
            menu = Category.mapMenuByName(menuName);
        } while (!coach.isEdible(menu));

        return menu;
    }
}
