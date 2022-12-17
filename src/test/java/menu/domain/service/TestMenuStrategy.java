package menu.domain.service;

import java.util.ArrayList;
import java.util.List;

public class TestMenuStrategy implements MenuStrategy {

    private final List<String> menus;

    public TestMenuStrategy(List<String> menus) {
        this.menus = menus;
    }

    @Override
    public List<String> generate(List<String> menuNames) {
        List<String> result = new ArrayList<>(menus);
        menus.remove(0);
        return result;
    }
}
