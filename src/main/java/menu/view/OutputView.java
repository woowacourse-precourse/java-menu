package menu.view;

public class OutputView {

    private static final String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String BLANK = "";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String END_RECOMMEND = "추천을 완료했습니다.";

    // TODO Enum 을 통해 형식으로 출력하도록 변경
    private static final String DIVISION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
    private static final String COACH_RECOMMENDED_FOOD_FORMAT = "[ %s | %s ]";

    public static void printRecommendStart() {
        System.out.println(START_RECOMMEND);
        System.out.println(BLANK);
    }

    public static void printRecommendResult() {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(BLANK);
        printRecommends();
        System.out.println(END_RECOMMEND);
    }

    private static void printRecommends() {
        System.out.println(DIVISION);
        System.out.println(CATEGORY);
        System.out.println(COACH_RECOMMENDED_FOOD_FORMAT);
    }
}
