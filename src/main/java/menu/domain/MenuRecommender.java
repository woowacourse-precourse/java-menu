package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MenuRecommender {

    private final Coaches coaches;
    private final MenuCategoriesOfDay foodMenuCategoriesOfDay;

    public MenuRecommender(List<Coach> coaches) {
        this.coaches = new Coaches(coaches);
        foodMenuCategoriesOfDay = new MenuCategoriesOfDay();
    }

    public MenuResult recommendByDay() {
        for (Day day : Day.values()) {
            MenuCategory category = generateCategory(day);
            setMenuByDayAndCategory(day, category);
        }
        return new MenuResult(coaches, foodMenuCategoriesOfDay);
    }

    private void setMenuByDayAndCategory(Day day, MenuCategory category) {
        for (Coach coach : coaches.get()) {
            Menu randomMenu = getRandomMenu(category, coach);
            coach.putDayByMenu(day, randomMenu);
        }
    }

    private Menu getRandomMenu(MenuCategory category, Coach coach) {
        String menuName = Randoms.shuffle(category.getFoods()).get(0);
        Menu menu = MenuRepository.findByName(menuName);
        if (coach.isBlacklist(menu) || coach.isDuplicate(menu)) {
            return getRandomMenu(category, coach);
        }
        return menu;
    }


    private MenuCategory generateCategory(Day day) {
        MenuCategory category = MenuCategory.of(
                Randoms.pickNumberInRange(MenuCategory.getFirstNumber(), MenuCategory.getLastNumber()));
        if (getCategorySelectCount(category) == 2) {
            return generateCategory(day);
        }
        foodMenuCategoriesOfDay.put(day, category);
        return category;
    }

    private long getCategorySelectCount(MenuCategory category) {
        return foodMenuCategoriesOfDay.getCategoryCount(category);
    }
}
