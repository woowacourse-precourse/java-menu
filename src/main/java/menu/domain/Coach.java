package menu.domain;


import java.util.List;
import java.util.Map;

public class Coach {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;

    private final String name;
    private Blacklist blacklist;
    private final LunchTable lunchTable;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        lunchTable = new LunchTable();
    }

    private void validateName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }
    }

    public Map<Day, Menu> getMenus() {
        return lunchTable.getMenus();
    }

    public void setBlacklist(List<Menu> menus) {
        this.blacklist = new Blacklist(menus);
    }

    public String getName() {
        return name;
    }

    public void putDayByMenu(Day day, Menu menu) {
        lunchTable.put(day, menu);
    }

    public boolean isBlacklist(Menu menu) {
        return blacklist.isExist(menu);
    }

    public boolean isDuplicate(Menu menu) {
        return lunchTable.isExist(menu);
    }
}
