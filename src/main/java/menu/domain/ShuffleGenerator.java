package menu.domain;

import java.util.List;

@FunctionalInterface
public interface ShuffleGenerator {

    List<String> generate(List<String> menus);
}
