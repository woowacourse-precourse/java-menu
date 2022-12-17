package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private static final int MIN_NAME_SIZE = 2;
    private static final int MAX_NAME_SIZE = 4;
    private static final int MAX_HATE_MENUS_SIZE = 2;

    private final String name;
    private List<String> hateMenus = new ArrayList<>();
    private List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        int length = name.length();
        if (length < MIN_NAME_SIZE || length > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자에서 4글자입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void setHateMenus(List<String> hateMenus) {
        if (isOverSize(hateMenus)) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개까지 가능합니다.");
        }

        for (String hateMenu : hateMenus) {
            if (isEmpty(hateMenu)) {
                return;
            }
            if (!Menu.isExist(hateMenu)) {
                throw new IllegalArgumentException("존재하지 않는 메뉴를 입력했습니다. 다시 입력해 주세요.");
            }
            this.hateMenus.add(hateMenu);
        }
    }

    private boolean isEmpty(String hateMenu) {
        return hateMenus.isEmpty();
    }

    private boolean isOverSize(List<String> hateMenus) {
        return hateMenus.size() > MAX_HATE_MENUS_SIZE;
    }

    public void setRecommendedMenus(String menu) {
        if (this.hateMenus.contains(menu)) {
            throw new IllegalStateException("먹지 못하는 음식이 존재합니다. 다시 추천해주세요.");
        }

        this.recommendedMenus.add(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) && Objects.equals(hateMenus, coach.hateMenus) && Objects.equals(recommendedMenus, coach.recommendedMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hateMenus, recommendedMenus);
    }
}
