package menu.model.menu;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMenuGenerator {
    public Menu pickMenuByCategory(Category category, List<Menu> exceptedMenuList) {
        List<String> menuList = category.getMenuList();
        removeHatingMenu(menuList, exceptedMenuList);

        String menuName = Randoms.shuffle(menuList).get(0);
        return new Menu(menuName);
    }

    private void removeHatingMenu(List<String> menuList, List<Menu> exceptedMenuList) {
        for(Menu exceptedMenu : exceptedMenuList) {
            menuList.remove(exceptedMenu.getName());
        }
    }
}
