package menu.view;

import menu.domain.category.Categories;
import menu.service.LunchSuggestion;

public class OutputView {

    public final void print(final Messages message) {
        System.out.println(message.getMessage());
    }

    public final void print(final Messages message, final String output) {
        System.out.printf(message.getMessage(), output);
    }

    public void printLunchSuggestion(LunchSuggestion lunchSuggestion) {
        System.out.println(lunchSuggestion);
    }

    public void printCategories(Categories categories) {
        System.out.println(categories);
    }
}
