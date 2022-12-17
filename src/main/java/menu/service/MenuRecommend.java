package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Group;
import menu.domain.Recommend;
import menu.domain.enums.Category;
import menu.domain.enums.Weekday;
import menu.usecase.MenuRecommendUseCase;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class MenuRecommend implements MenuRecommendUseCase {

    private static final int FIRST_SELECT_MENU_INDEX = 0;
    private static final int FIRST_CATEGORY_INDEX = 1;
    private static final int LAST_CATEGORY_INDEX = 5;

    /**
     * 요일별로 반복하여 코치별로 메뉴 추천
     */
    @Override
    public Group command(Command command) {
        Group group = new Group(command.coaches());
        for (Weekday weekday : Weekday.weekdays()) {
            Category category = selectCategoryByDay(weekday, group.coaches());
            group.confirmDayCategory(weekday, category);
            recommendByCategoryAndDay(weekday, category, group.coaches());
        }
        return group;
    }

    private void recommendByCategoryAndDay(Weekday weekday, Category category, List<Coach> coaches) {
        for (Coach coach : coaches) {
            recommendForCoachOfCategory(coach, category, weekday);
        }
    }

    private void recommendForCoachOfCategory(Coach coach, Category category, Weekday weekday) {
        Food food = selectMenuForCoach(coach, category);
        Recommend recommend = new Recommend(coach, weekday, food);
        coach.addRecommend(recommend);
    }


    private Category selectCategoryByDay(Weekday weekday, List<Coach> coaches) {
        Category selected;
        do { // 2회 이상 중복되는 카테고리가 없을 때까지
            selected = Category.mapByNumber(pickNumberInRange(FIRST_CATEGORY_INDEX, LAST_CATEGORY_INDEX));
        } while (isDuplicated(selected, coaches));

        return selected;
    }

    private boolean isDuplicated(Category category, List<Coach> coaches) {
        for (Coach coach : coaches) {
            //TODO 한명한테만
            if (coach.isDuplicatedCategory(category)){
                return true;
            }
        }
        return false;
    }

    private Food selectMenuForCoach(Coach coach, Category category) {
        List<String> foodNames = category.foodNames();
        Food food;
        do {
            String foodName = Randoms.shuffle(foodNames).get(FIRST_SELECT_MENU_INDEX);
            food = Category.mapFoodByName(foodName);
        } while (!coach.isEdible(food));

        return food;
    }
}
