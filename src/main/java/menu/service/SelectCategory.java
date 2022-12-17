package menu.service;

import menu.domain.Group;
import menu.domain.enums.Category;
import menu.domain.enums.Weekday;
import menu.usecase.SelectCategoryUseCase;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class SelectCategory implements SelectCategoryUseCase {

    private static final int FIRST_CATEGORY_INDEX = 1;
    private static final int LAST_CATEGORY_INDEX = 5;

    @Override
    public void command(final Command command) {
        Group group = command.group();
        for (Weekday weekday : Weekday.weekdays()) {
            Category category = selectCategory(group);
            group.confirmDayCategory(weekday, category);
        }
    }

    private Category selectCategory(final Group group) {
        Category selected;
        do { // 2회 이상 중복되는 카테고리가 없을 때까지
            selected = Category.mapByNumber(
                    pickNumberInRange(FIRST_CATEGORY_INDEX, LAST_CATEGORY_INDEX));
        } while (group.isDuplicatedCategory(selected));

        return selected;
    }
}
