package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenMenu {
    private final List<String> forbiddenMenus = new ArrayList<>();

    private ForbiddenMenu() {

    }

    public static ForbiddenMenu getForbiddenMenuInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final ForbiddenMenu INSTANCE = new ForbiddenMenu();
    }

    public void saveForbiddenMenu(List<String> menus) {
        for (String menu : menus) {
            if (!forbiddenMenus.contains(menu)) {
                forbiddenMenus.add(menu);
            }
        }
        System.out.println(forbiddenMenus);
    }

    public List<String> removeForbiddenMenusInMenu(List<String> menus) {
        List<String> copyMenus = new ArrayList<>(menus);
        copyMenus.removeIf(forbiddenMenus::contains);
        return copyMenus;
    }

}
