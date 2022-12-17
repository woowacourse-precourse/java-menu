package domain;

import java.util.List;

import util.Validator;

public class SelectedCategories {
    private final List<String> selectedCategories;

    public SelectedCategories(List<String> selectedCategories) {
        Validator.validateCategories(selectedCategories);
        this.selectedCategories = selectedCategories;
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }
}
