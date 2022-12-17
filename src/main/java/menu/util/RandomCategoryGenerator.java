package menu.util;

import menu.constants.Category;

@FunctionalInterface
public interface RandomCategoryGenerator {
    Category generate();
}
