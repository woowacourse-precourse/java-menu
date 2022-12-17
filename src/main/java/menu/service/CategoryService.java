package menu.service;

import menu.domain.Category;
import menu.domain.CategoryRepository;

import java.util.List;

public class CategoryService {
    private static final List<String> categoryNames = List.of("일식", "한식", "중식", "아시안", "양식");

    public void initialize() {
        for (String categoryName : categoryNames) {
            CategoryRepository.addCategory(new Category(categoryName));
        }
    }
}
