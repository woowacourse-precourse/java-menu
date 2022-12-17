package menu.view;

import menu.enums.MyValue;
import menu.enums.RuntimeMessage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INITIAL_SETTING = "";
    private static final String SPACE = " ";
    private static final String DELIMITER = "|";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    public void printStartMessage() {
        System.out.println(RuntimeMessage.PROGRAM_START_MESSAGE.getMessage());
    }

    public void printInputCoachNameMessage() {
        System.out.println(RuntimeMessage.COACH_NAME_INPUT_MESSAGE.getMessage());
    }

    public void printFinalResult(Map<String, List<String>> foodRecommendedByCoaches, List<String> pickedCategories) {
        System.out.println(RuntimeMessage.MENU_RECOMMENDATION_RESULT_MESSAGE.getMessage());
        System.out.println(RuntimeMessage.DAY_OF_WEEK_LIST_MESSAGE.getMessage());
        makeCategoryPhrase(pickedCategories);
        printRecommendationResult(foodRecommendedByCoaches);
        System.out.println(RuntimeMessage.PROGRAM_END_MESSAGE.getMessage());
    }

    public void makeCategoryPhrase(List<String> pickedCategories) {
        String phrase = INITIAL_SETTING;
        for (int i = MyValue.MONDAY.getValue(); i < MyValue.SATURDAY.getValue(); i++) {
            phrase += SPACE + pickedCategories.get(i) + SPACE;

            if (i != MyValue.FRIDAY.getValue()) {
                phrase += DELIMITER;
            }
        }
        System.out.println(START_BRACKET + " 카테고리 " + DELIMITER + phrase + END_BRACKET);;
    }

    public void printRecommendationResult(Map<String, List<String>> foodRecommendedByCoaches) {
        List<String> coachName = foodRecommendedByCoaches.keySet().stream().collect(Collectors.toList());
        for (String name : coachName) {
            makeRecommendationPhrase(name, foodRecommendedByCoaches);
        }
    }

    public void makeRecommendationPhrase(String name, Map<String, List<String>> foodRecommendedByCoaches) {
        String phrase = INITIAL_SETTING;
        for (int i = MyValue.MONDAY.getValue(); i < MyValue.SATURDAY.getValue(); i++) {
            phrase += SPACE + foodRecommendedByCoaches.get(name).get(i) + SPACE;

            if (i != MyValue.FRIDAY.getValue()) {
                phrase += DELIMITER;
            }
        }
        System.out.println(START_BRACKET + SPACE + name + SPACE + DELIMITER + phrase + END_BRACKET);
    }

}
