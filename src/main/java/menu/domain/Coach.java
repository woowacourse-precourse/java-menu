package menu.domain;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 4;
    private static final int BLACKLIST_MAX_SIZE = 2;

    private final String name;
    private List<Menu> blacklist;
    private final Map<Day, Menu> menus;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        menus = new HashMap<>();
    }

    private void validateName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }
    }

    public Map<Day, Menu> getMenus() {
        return Collections.unmodifiableMap(menus);
    }

    public void setBlacklist(List<Menu> blacklist) {
        validateBlacklist(blacklist);
        this.blacklist = blacklist;
    }

    private void validateBlacklist(List<Menu> blacklist) {
        if (blacklist.size() > BLACKLIST_MAX_SIZE) {
            throw new IllegalArgumentException("못 먹는 메뉴는 2가지까지만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }

    public void putDayByMenu(Day day, Menu menu) {
        menus.put(day, menu);
    }

    public boolean isBlacklist(Menu menu) {
        return blacklist.contains(menu);
    }

    public boolean isDuplicate(Menu menu) {
        return menus.values()
                .stream()
                .anyMatch(coachMenu -> coachMenu.equals(menu));
    }
}
