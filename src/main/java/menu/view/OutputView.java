package menu.view;

import menu.domain.category.Category;
import menu.domain.day.Day;
import menu.view.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printStart() {
        print(Message.START.getMessage());
    }

    public void printCoachNameInputGuide() {
        print(Message.COACH_NAME_GUIDE.getMessage());
    }

    public void printHateMenuGuide(String name) {
        print(Message.HATE_MENU_GUIDE.getFormattedMessage(name));
    }

    public void printRecommendedResult(List<Day> rowTitles, Map<String, List<String>> menusByCoach, List<Category> categories) {
        print(Message.RESULT_GUIDE.getMessage());
        String titleMessage = makeTitleMessage(rowTitles);
        print(titleMessage);
        String categoryMessage = makeCategoryMessage(categories);
        print(categoryMessage);
        printRecommendedMenuByCoach(menusByCoach);
        print(Message.RECOMMENDATION_FINISHING.getMessage());
    }

    private String makeCategoryMessage(List<Category> categories) {
        List<String> words = new ArrayList<>();
        words.add(Message.CATEGORY.getMessage());
        words.addAll(categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList()));
        return Message.PRINT_FORM.getFormattedMessage(String.join(Message.DELIMITER.getMessage(), words));
    }

    private void printRecommendedMenuByCoach(Map<String, List<String>> menusByCoach) {
        for (String coachName : menusByCoach.keySet()) {
            List<String> words = new ArrayList<>();
            words.add(coachName);
            words.addAll(menusByCoach.get(coachName));
            String recommendationMessage = Message.PRINT_FORM.getFormattedMessage(String.join(Message.DELIMITER.getMessage(), words));
            print(recommendationMessage);
        }
    }

    private static String makeTitleMessage(List<Day> rowTitles) {
        List<String> words = new ArrayList<>();
        words.add(Message.FIRST_ROW_TITLE.getMessage());
        words.addAll(rowTitles.stream()
                .map(Day::getDayName)
                .collect(Collectors.toList()));
        return Message.PRINT_FORM.getFormattedMessage(String.join(Message.DELIMITER.getMessage(), words));
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}