package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private final String name;
    private List<String> hateMenus = new ArrayList<>();
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public void setHateMenus(List<String> hateMenus) {
        for (String hateMenu : hateMenus) {
            this.hateMenus.add(hateMenu);
        }
    }

    public void setRecommendedMenus(List<String> menus) {
        for (String menu : menus) {
            if (this.hateMenus.contains(menu)) {
                throw new IllegalStateException("먹지 못하는 음식이 존재합니다. 다시 추천해주세요.");
            }
        }

        for (String menu : menus) {
            this.recommendedMenus.add(menu);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
