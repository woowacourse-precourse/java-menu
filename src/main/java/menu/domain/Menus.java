package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private final List<String> menus = new ArrayList<>();

    public Menus(String menus) {
        this.menus.addAll(splitMenu(menus));
    }

    private List<String> splitMenu(String menus) {
        return Arrays.stream(menus.split(","))
                .collect(Collectors.toList());
    }
}
