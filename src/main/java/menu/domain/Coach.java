package menu.domain;

import java.util.List;
import java.util.Objects;

public class Coach {
    private static final String ERROR_NAME_LENGTH = "[ERROR] 코치의 이름은 최소 2글자 최대 4글자까지 입력 가능합니다.";

    private final String name;
    private final UnavailableMenu unavailableMenu;

    private Coach(String name) {
        validateName(name.length());
        this.name = name;
        this.unavailableMenu = new UnavailableMenu();
    }

    private static void validateName(int length) {
        if (!(length >= 2 && length <= 4)) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public static Coach createCoach(String name) {
        return new Coach(name);
    }

    public String getName() {
        return name;
    }

    public void addUnavailableMenu(List<String> menus) {
        for (String menu : menus) {
            unavailableMenu.addMenu(menu);
        }
    }

    public boolean canNotEatMenu(String menu) {
        return unavailableMenu.hasMenu(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) &&
                Objects.equals(unavailableMenu, coach.unavailableMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unavailableMenu);
    }
}
