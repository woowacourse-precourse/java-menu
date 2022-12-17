package menu.domain.menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.type.Category;

public class CategoryHistoryRepositoryImpl implements CategoryHistoryRepository {

    private static final List<Category> categoryHistory = new ArrayList<>();

    @Override
    public boolean existTwice(Category category) {
        return (int) categoryHistory.stream().filter(history -> history.equals(category)).count() == 2;
    }
}
