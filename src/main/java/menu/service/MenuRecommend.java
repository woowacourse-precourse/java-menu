package menu.service;

import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Group;
import menu.domain.enums.Category;
import menu.domain.enums.Weekday;
import menu.usecase.MenuRecommendUseCase;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MenuRecommend implements MenuRecommendUseCase {

    private static final int FIRST_SELECT_MENU_INDEX = 0;
    private static final int FIRST_CATEGORY_INDEX = 1;
    private static final int LAST_CATEGORY_INDEX = 5;

    /**
     * 요일별로 반복하여 코치별로 메뉴 추천
     */
    @Override
    public void command(final Command command) {
        Group group = command.group();

        for (Weekday weekday : Weekday.weekdays()) {
            Category category = selectCategory(group);
            group.confirmDayCategory(weekday, category);
            recommendByCategoryAndDay(category, group);
        }
    }

    private void recommendByCategoryAndDay(final Category category,
                                           final Group group) {
        for (Coach coach : group.coaches()) {
            recommendForCoachOfCategory(coach, category);
        }
    }

    private void recommendForCoachOfCategory(final Coach coach,
                                             final Category category) {
        Food food = selectMenuForCoach(coach, category);
        coach.addRecommend(food);
    }

    private Category selectCategory(final Group group) {
        Category selected;
        do { // 2회 이상 중복되는 카테고리가 없을 때까지
            selected = Category.mapByNumber(
                    pickNumberInRange(FIRST_CATEGORY_INDEX, LAST_CATEGORY_INDEX));
        } while (group.isDuplicatedCategory(selected));

        return selected;
    }

    private Food selectMenuForCoach(final Coach coach,
                                    final Category category) {
        List<String> foodNames = category.foodNames();
        Food food;
        do {
            String foodName = shuffle(foodNames).get(FIRST_SELECT_MENU_INDEX);
            food = Category.mapFoodByName(foodName);
        } while (!coach.isEdible(food));

        return food;
    }
}
