package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRecommend {

    private final Weekday weekday;
    private final Category category;

    public CategoryRecommend(Weekday weekday) {
        this.weekday = weekday;
        this.category = getRandomCategory();
    }

    public Category getRandomCategory() {
        Category category = Category.getByNumber(Randoms.pickNumberInRange(1, 5));
        if (CategoryRecommendRepository.hasOverDuplicatedCategory(category)) {
            return getCategory();
        }
        return category;
    }

    public boolean hasSameWeekday(Weekday weekday) {
        return this.weekday.equals(weekday);
    }

    public boolean hasSameCategory(Category category) {
        return this.category.equals(category);
    }

    public Category getCategory() {
        return category;
    }
}
