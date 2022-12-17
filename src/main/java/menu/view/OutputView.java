package menu.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static menu.util.Constants.*;

public class OutputView {
    StringBuilder sb;
    StringBuilder sb2;
    StringJoiner sj;

    public OutputView() {
        sb = new StringBuilder();
        sb2 = new StringBuilder();
    }

    public void printStartGuide() {
        System.out.println(START_GUIDE);
    }

    public void printNameInputGuide() {
        System.out.println(
                String.format(NAME_INPUT_GUIDE, COACH_NAMES_INPUT_SEPARATOR)
        );
    }

    public void printError(String errorMessage) {
        System.out.println(DEFAULT_ERROR_MESSAGE + errorMessage);
    }

    public void printHateMenuInputGuide(String name) {
        System.out.printf(HATE_MENU_INPUT_GUIDE, name);
    }

    public void printResult(List<String> thisWeekCategories, Map<String, List<String>> ateMenuNamesByCoachName) {
        System.out.println(START_RESULT_GUIDE);
        System.out.println(getResult(thisWeekCategories, ateMenuNamesByCoachName));
        System.out.println(END_RESULT_GUIDE);
    }

    public String getResult(List<String> thisWeekCategories, Map<String, List<String>> ateMenuNamesByCoachName) {
        sb.setLength(0);
        return sb.append(createWeekGuide())
                .append("\n")
                .append(createCategoryGuide(thisWeekCategories))
                .append("\n")
                .append(getRecommendationStatusGuide(ateMenuNamesByCoachName))
                .toString();
    }

    private String createWeekGuide() {
        sj = new StringJoiner(WEEK_GUIDE_DELIMITER, WEEK_GUIDE_PREFIX, WEEK_GUIDE_SUFFIX);
        sj.add("구분");
        for (String day : DAY_OF_WEEK) {
            sj.add(day);
        }
        return sj.toString();
    }

    private String createCategoryGuide(List<String> thisWeeKCategoryNames) {
        sj = new StringJoiner(CATEGORY_GUIDE_DELIMITER, CATEGORY_GUIDE_PREFIX, CATEGORY_GUIDE_SUFFIX);
        sj.add("카테고리");
        for (String categoryName : thisWeeKCategoryNames) {
            sj.add(categoryName);
        }
        return sj.toString();
    }

    private String getRecommendationStatusGuide(Map<String, List<String>> ateMenuNamesByCoachName) {
        sb2.setLength(0);
        for (String coachName : ateMenuNamesByCoachName.keySet()) {
            sb2.append(getEachRecommendationStatusGuide(ateMenuNamesByCoachName, coachName))
                    .append("\n");
        }
        return sb2.toString().trim();
    }

    private String getEachRecommendationStatusGuide(Map<String, List<String>> ateMenuNamesByCoachName, String coachName) {
        sj = new StringJoiner(RECOMMEND_GUIDE_DELIMITER, RECOMMEND_GUIDE_PREFIX, RECOMMEND_GUIDE_SUFFIX);
        sj.add(coachName);
        for (String ateMenuName : ateMenuNamesByCoachName.get(coachName)) {
            sj.add(ateMenuName);
        }
        return sj.toString();
    }

}
