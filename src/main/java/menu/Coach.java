package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coach {
    private String name;
    private List<String> hateMenus;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHateMenus(List<String> hateMenus) {
        this.hateMenus = new ArrayList<>(hateMenus);
    }

    public List<String> getWeeklyMenuList(List<Category> categories) {
        List<String> weeklyMenuList = new ArrayList<>();

        Set<String> menuAlreadyPicked = new HashSet<>();

        for (Category category : categories) {//5 times
            final List<String> menuList = category.getMenuList();
            String menu;
            while (true) {

                menu = Randoms.shuffle(menuList).get(0);

                if (!(isDuplicateMenu(menuAlreadyPicked, menu) || isHateMenu(menu))) {
                    menuAlreadyPicked.add(menu);
                    break;
                }
            }

            weeklyMenuList.add(menu);
        }

        return weeklyMenuList;
    }

    private boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }

    private boolean isDuplicateMenu(Set<String> menuAlreadyPicked, String menu) {
        return menuAlreadyPicked.contains(menu);
    }
}
