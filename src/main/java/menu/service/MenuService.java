package menu.service;
public class MenuService implements Menu {
    public MenuService(final Map<String, List<String>> menus, final Picker picker) {
        this.menus = stringToMenuRevert(menus);
        this.picker = picker;
    }
    }
