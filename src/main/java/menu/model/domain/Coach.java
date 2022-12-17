package menu.model.domain;

import java.util.ArrayList;

public class Coach {
    public static final int NAME_MAX = 4;
    public static final int NAME_MIN = 2;

    private final String name;
    private DislikeMenus dislikeMenus = new DislikeMenus(new ArrayList<>());

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < NAME_MIN || name.length() > NAME_MAX) {
            throw new IllegalArgumentException("코치 이름의 길이는 최소 2, 최대 4여야 합니다.");
        }
    }

    public void updateDislikeMenus(DislikeMenus menus) {
        dislikeMenus = dislikeMenus;
    }

    public String getName() {
        return name;
    }

    public boolean dislike(String menu) {
        return dislikeMenus.contains(menu);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", dislikeMenus=" + dislikeMenus +
                '}';
    }
}
