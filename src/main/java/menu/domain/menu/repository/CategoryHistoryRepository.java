package menu.domain.menu.repository;

import menu.domain.menu.type.Category;

public interface CategoryHistoryRepository {

    boolean existTwice(Category category);
}
