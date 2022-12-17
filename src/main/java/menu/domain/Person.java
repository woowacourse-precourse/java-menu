package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private Menus unavailable;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void adUnavailableMenus(String menus) {
        String[] split = validate(menus);
        List<Menu> result = Arrays.stream(split)
                .map(Menu::new)
                .collect(Collectors.toList());
        unavailable = new Menus(result);
    }

    private String[] validate(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) != ',' || Character.isAlphabetic(input.charAt(index))) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요");
            }
        }
        return input.split(",");
    }
}
