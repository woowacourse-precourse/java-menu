package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.repository.Repository;

public class MenuSelector {

    public static void startWeek(Coaches coaches){
        for (String day : Repository.weeks){
            Category category = getCategory(coaches);
            addMenus(coaches, category);
        }

    }
    private static Category getCategory(Coaches coaches) {
        while (true){
            Category category = selectCategory(Randoms.pickNumberInRange(1, 5));
            if (checkUnder3(coaches, category)) {
                continue;
            }
            coaches.addCategories(category);
            return category;
        }
    }

    private static boolean checkUnder3(Coaches coaches, Category category) {
        int count = addCount(coaches, category);
        if (count==2){
            return true;
        }
        return false;
    }

    private static int addCount(Coaches coaches, Category category) {
        //해당 카테고리가 두개 이상이면 continue
        int count = 0;
        for (String doneCategory : coaches.getCategories()){
            if (doneCategory== category.getCategory()){
                count++;
            }
        }
        return count;
    }

    private static Category selectCategory(int categoryNum){
        return Repository.categoryOf(categoryNum);
    }

    private static void addMenus(Coaches coaches, Category category) {
        for(Coach coach : coaches.getCoaches()){
            addMenu(category, coach);
        }
    }

    private static void addMenu(Category category, Coach coach) {
        while(true){
            if (checkCanSelectMenu(category, coach)) {
                continue;
            }
            break;
        }
    }

    private static boolean checkCanSelectMenu(Category category, Coach coach) {
        String menu = Randoms.shuffle(category.getMenus()).get(0);
        if (checkAlreadyEat(coach, menu)) {
            return true;
        }
        if (checkCannotEat(coach, menu)) {
            return true;
        }
        coach.addDoneMenus(menu);
        return false;
    }

    private static boolean checkCannotEat(Coach coach, String menu) {
        if (coach.getProhibitedMenus().contains(menu)){
            return true;
        }
        return false;
    }

    private static boolean checkAlreadyEat(Coach coach, String menu) {
        if (coach.getDoneMenus().contains(menu)){
            return true;
        }
        return false;
    }
}
