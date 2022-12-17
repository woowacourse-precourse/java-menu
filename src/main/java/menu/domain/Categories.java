package menu.domain;

import menu.utills.Converter;
import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Categories {
    private final List<Category> categories = new ArrayList<>();

    public void addCategories(Category category) {
        if(duplicatedDouble(category)) {
            return;
        }
        categories.add(category);
    }

    public boolean isFull() {
        return categories.size() == 5;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        List<String> categoryNames= categories.stream()
                .map(Category::getLabel)
                .collect(Collectors.toList());
        return Converter.toStringByDelimiter(categoryNames);
    }

    private boolean duplicatedDouble(Category newCategory) {
        int count = (int) categories.stream()
                .filter(category -> category.equals(newCategory))
                .count();
        return count >= 2;
    }
}
