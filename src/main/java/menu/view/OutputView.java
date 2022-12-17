package menu.view;

import menu.view.constant.DayStyle;
import menu.view.constant.InputPhrase;
import menu.view.constant.OutputPhrase;
import menu.view.constant.Prefix;
import menu.view.constant.RecommendationStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private OutputView(){}

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }

    public void printPhrase(String phrase) {
        System.out.println(phrase);
    }

    public void printErrorMessage(String message) {
        System.out.println(Prefix.ERROR.getPrefix() + message);
    }

    public void printRecommendations(List<String> categories, List<List<String>> recommendations) {
        printPhrase(OutputPhrase.RESULT.getPhrase());
        System.out.println(styleDays());
        System.out.println(styleCategories(categories));
        recommendations.stream().map(this::styleRecommendation)
                .forEach(System.out::println);
    }

    private String styleDays() {
        List<String> dayOutput = new ArrayList<>();
        dayOutput.add(RecommendationStyle.DAY.getStyle());
        Arrays.stream(DayStyle.values()).forEach(day -> dayOutput.add(day.getStyle()));
        return styleElements(dayOutput);
    }

    private String styleCategories(List<String> categories) {
        List<String> categoryOutput = new ArrayList<>();
        categoryOutput.add(RecommendationStyle.CATEGORY.getStyle());
        categoryOutput.addAll(categories);
        return styleElements(categoryOutput);
    }

    private String styleRecommendation(List<String> recommendation) {
        return styleElements(recommendation);
    }

    private String styleElements(List<String> elements) {
        return elements.stream().collect(Collectors.joining(
                RecommendationStyle.DELIMITER.getStyle(),
                RecommendationStyle.START.getStyle(),
                RecommendationStyle.END.getStyle()
        ));
    }
}
