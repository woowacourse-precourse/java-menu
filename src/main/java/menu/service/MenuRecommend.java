package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Recommend;
import menu.domain.WeekRecommends;
import menu.domain.enums.Category;
import menu.domain.enums.Weekday;
import menu.usecase.MenuRecommendUseCase;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.stream.Collectors.toUnmodifiableList;

public class MenuRecommend implements MenuRecommendUseCase {

    private static final int FIRST_SELECT_MENU_INDEX = 0;
    private static final int FIRST_CATEGORY_INDEX = 1;
    private static final int LAST_CATEGORY_INDEX = 5;

    /**
     * 요일별로 반복하여 코치별로 메뉴 추천
     */
    @Override
    public List<WeekRecommends> command(Command command) {
        return Weekday.weekdays()
                .stream()
                .map(it -> new WeekRecommends(it, recommendForCoachByrdDay(it, command.coaches())))
                .collect(toUnmodifiableList());
    }

    /**
     * 코치들에게 요일별로 메뉴를 추천한다.
     */
    private List<Recommend> recommendForCoachByrdDay(Weekday weekday, List<Coach> coaches) {
        return coaches.stream()
                .map(it -> recommendForCoach(weekday, it))
                .collect(toUnmodifiableList());
    }

    /**
     * 코치에게 해당 요일에 대한 메뉴를 추천한다.
     */
    private Recommend recommendForCoach(Weekday weekday, Coach coach) {
        Category category = selectCategoryForCoach(coach);
        Food food = selectMenuForCoach(coach, category);
        return new Recommend(coach, weekday, food);
    }

    private Category selectCategoryForCoach(Coach coach) {
        Category selected;
        do { // 2회 이상 중복되는 카테고리가 없을 때까지
            selected = Category.mapByNumber(pickNumberInRange(FIRST_CATEGORY_INDEX, LAST_CATEGORY_INDEX));
        } while (coach.isDuplicatedCategory(selected));

        return selected;
    }

    private Food selectMenuForCoach(Coach coach, Category category) {
        // 메뉴 렌덤 선택
        List<String> foodNames = category.foodNames();
        Food food;
        do {
            String foodName = Randoms.shuffle(foodNames).get(FIRST_SELECT_MENU_INDEX);
            food = category.mapFoodByName(foodName);
        } while (coach.isEdible(food));

        return food;
    }
}
