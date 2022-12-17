package menu.view;

import menu.domain.CoachFoodRecommand;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String SPLIT = ",";
    private static final String FINAL_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_START = "[ 구분 ";
    private static final String SPACE = " ";
    private static final String END = "]";
    private static final String START = "[";
    private static final String EACH = "|";
    private static final String LAST_MESSAGE = "추천을 완료했습니다.";


    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGetCoachNameMessage() {
        System.out.println(GET_COACH_NAME_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printCoachNames(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            result.append(names.get(i));
            result.append(SPLIT);
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    public static void printFinalResult(List<String> categories, List<CoachFoodRecommand> foodRecommands) {
        printFianlResultMessage();
        printCategories(categories);
        printCoachRecommandFoods(foodRecommands);
        printLastMessage();
    }

    private static void printCoachRecommandFoods(List<CoachFoodRecommand> foodRecommands) {
        for (CoachFoodRecommand foodRecommand : foodRecommands) {
            printEachCoachRecommandFoods(foodRecommand);
        }
    }

    private static void printEachCoachRecommandFoods(CoachFoodRecommand foodRecommand) {
        StringBuilder result = new StringBuilder();
        result.append(START + foodRecommand.getCoach().getName() + SPACE);
        List<String> foods = foodRecommand.getFoods();
        for (String food : foods) {
            result.append(EACH + SPACE + food + SPACE);
        }
        result.append(END);
        System.out.println(result);
    }

    private static void printCategories(List<String> categories) {
        StringBuilder result = new StringBuilder();
        result.append(CATEGORY_START);
        for (String category : categories) {
            result.append(EACH + SPACE + category + SPACE);
        }
        result.append(END);
        System.out.println(result);
    }

    private static void printFianlResultMessage() {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(DAY_MESSAGE);
    }

    private static void printLastMessage() {
        System.out.println(LAST_MESSAGE);
    }
}
