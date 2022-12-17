package menu.entity;

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
            String menu = findRandomMenu(menuAlreadyPicked, category.getMenuList());
            weeklyMenuList.add(menu);
        }
        return weeklyMenuList;
    }

    private String findRandomMenu(Set<String> menuAlreadyPicked, List<String> menuList) {
        String menu;
        do {
            menu = Randoms.shuffle(menuList).get(0);
        } while (!isAvilableMenu(menuAlreadyPicked, menu));
        return menu;
    }

    private boolean isAvilableMenu(Set<String> menuAlreadyPicked, String menu) {
        if (!(isDuplicateMenu(menuAlreadyPicked, menu) || isHateMenu(menu))) {
            menuAlreadyPicked.add(menu);
            return true;
        }
        return false;
    }

    private boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }

    private boolean isDuplicateMenu(Set<String> menuAlreadyPicked, String menu) {
        return menuAlreadyPicked.contains(menu);
    }

    public static Coach nameOf(String name) {
        if (name.length() >= 2 && name.length() <= 4)
            return new Coach(name);
        throw new IllegalArgumentException("코치의 이름은 2글자에서 4글자여야 합니다.");
    }
}
