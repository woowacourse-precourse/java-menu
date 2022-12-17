package menu.view;

import menu.ProgramController;
import menu.category.Category;
import menu.category.CategoryService;
import menu.coach.Coach;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_MESSAGE = "추천을 완료했습니다.";
    private static final String NEXT_LINE = "\n";

    private static final String SET_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String SET_COACHES_CANNOT_EAT = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE_SET_COACHES_NAME = "코치는 최소 2명 이상, 5명 이하 입력해야 합니다.";
    private static final String ERROR_MESSAGE_SET_COACHES_CANNOT_EATS = "못 먹는 메뉴는 최대 2개까지만 가능하며, 존재하는 메뉴여야 합니다.";

    private static final String RECOMMEND_RESULT_MESSAGE_HEADER = "메뉴 추천 결과입니다.";
    private static final String RECOMMEND_RESULT_MESSAGE_WEEK = "구분";
    private static final String RECOMMEND_RESULT_MESSAGE_CATEGORY = "카테고리";
    private static final String RECOMMEND_RESULT_MESSAGE_START = "[ ";
    private static final String RECOMMEND_RESULT_MESSAGE_SEPARATOR = " | ";
    private static final String RECOMMEND_RESULT_MESSAGE_END = " ]";


    public static void printStartMessage() {
        System.out.println(START_MESSAGE + NEXT_LINE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE + NEXT_LINE);
    }

    public static void printSetCoachesName() {
        System.out.println(SET_COACHES_NAME);
    }

    public static void printSetCoachesCannotEat(Coach coach) {
        System.out.println(NEXT_LINE + coach.getName() + SET_COACHES_CANNOT_EAT);
    }

    /**
     * Error Messages
     */
    public static void printErrorMessage_setCoachesName() {
        System.out.println(ERROR_MESSAGE_START + ERROR_MESSAGE_SET_COACHES_NAME + NEXT_LINE);
    }

    public static void printErrorMessage_setCoachesCannotEats() {
        System.out.println(ERROR_MESSAGE_START + ERROR_MESSAGE_SET_COACHES_CANNOT_EATS + NEXT_LINE);
    }

    /**
     * Recommend Results
     */
    public static void printRecommendResult(List<Coach> coaches) {
        StringBuilder result = new StringBuilder(NEXT_LINE + RECOMMEND_RESULT_MESSAGE_HEADER + NEXT_LINE);
        result.append(printWeek()); // 구분 (요일 출력)
        result.append(NEXT_LINE);
        result.append(printRecommendResult_categories()); // 카테고리
        result.append(printRecommendResult_coaches(coaches)); // 코치, 코치별 메뉴
        System.out.println(result);
    }

    // 구분
    private static String printWeek() {
        StringBuilder result = new StringBuilder();
        result.append(RECOMMEND_RESULT_MESSAGE_START + RECOMMEND_RESULT_MESSAGE_WEEK + RECOMMEND_RESULT_MESSAGE_SEPARATOR);
        for (ProgramController.Week week : ProgramController.Week.values()) {
            result.append(week.getName());
            if (week.getName().compareTo(ProgramController.Week.FRIDAY.getName()) != 0) {
                result.append(RECOMMEND_RESULT_MESSAGE_SEPARATOR);
            }
        }
        result.append(RECOMMEND_RESULT_MESSAGE_END);
        return result.toString();
    }

    // 카테고리
    private static String printRecommendResult_categories() {
        StringBuilder result = new StringBuilder();
        result.append(RECOMMEND_RESULT_MESSAGE_START + RECOMMEND_RESULT_MESSAGE_CATEGORY + RECOMMEND_RESULT_MESSAGE_SEPARATOR);
        List<Integer> recommendCategoryNumbers = CategoryService.getRecommendCategoryNumbers();
        for (int i = 0; i < recommendCategoryNumbers.size(); i++) {
            result.append(Category.getCategoryNameByNumber(recommendCategoryNumbers.get(i)));
            if (i != recommendCategoryNumbers.size() - 1) result.append(RECOMMEND_RESULT_MESSAGE_SEPARATOR);
        }
        result.append(RECOMMEND_RESULT_MESSAGE_END + NEXT_LINE);
        return result.toString();
    }

    // 코치 정보들
    private static String printRecommendResult_coaches(List<Coach> coaches) {
        StringBuilder result = new StringBuilder();
        for (Coach coach : coaches) {
            result.append(printCoachName(coach));
            result.append(printMenusRecommended(coach));
            result.append(RECOMMEND_RESULT_MESSAGE_END + NEXT_LINE);
        }
        return result.toString();
    }

    // 코치 이름
    private static String printCoachName(Coach coach) {
        StringBuilder result = new StringBuilder();
        result.append(RECOMMEND_RESULT_MESSAGE_START);
        result.append(coach.getName());
        result.append(RECOMMEND_RESULT_MESSAGE_SEPARATOR);
        return result.toString();
    }

    // 코치별 추천 메뉴
    private static String printMenusRecommended(Coach coach) {
        StringBuilder result = new StringBuilder();
        List<String> menusRecommended = coach.getMenusRecommended();
        for (int i = 0; i < menusRecommended.size(); i++) {
            result.append(menusRecommended.get(i));
            if (i != menusRecommended.size() - 1) result.append(RECOMMEND_RESULT_MESSAGE_SEPARATOR);
        }
        return result.toString();
    }

}
