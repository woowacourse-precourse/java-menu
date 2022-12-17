package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private Menus unavailable;

    public Person(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
        return name;
    }

    public void addUnavailableMenus(String menus) {
        String[] split = validateUnavailableMenus(menus);
        List<Menu> result = Arrays.stream(split)
                .map(Menu::new)
                .collect(Collectors.toList());
        unavailable = new Menus(result);
    }

    private String[] validateUnavailableMenus(String input) {
        String[] split = input.split(",");
        for (String s : split) {
            if (!s.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요");
            }
        }
        if (split.length > 2) {
            throw new IllegalArgumentException("최대 2개의 못 먹는 메뉴만 입력할 수 있습니다.");
        }
        return split;
    }
}
