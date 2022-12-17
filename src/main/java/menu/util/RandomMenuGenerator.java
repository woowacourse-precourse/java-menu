package menu.util;

import menu.constants.Category;

@FunctionalInterface
public interface RandomMenuGenerator {
    String generate(Category category);
}
