package menu.view;

import menu.domain.Coach;
import menu.repository.CoachRepository;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String START_COMMENT = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAMES_COMMENT = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String COACH_FORBIDDEN_FOOD_COMMENT = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_COMMENT = "메뉴 추천 결과입니다.";
    private static final List<String> CATEGORIES_WEEK = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
    private static final String CATEGORY = "카테고리";


    private static final String OPEN_PARENTHESIS = "[ ";
    private static final String CLOSE_PARENTHESIS = " ]";
    private static final String MIDDLE_PARENTHESIS = " | ";

    public static void printStartComment() {
        System.out.println(START_COMMENT);
        System.out.println();
    }

    public static void printCoachNameComment() {
        System.out.println(COACH_NAMES_COMMENT);
    }

    public static void printCoachForbiddenFoodComment(String name) {
        System.out.printf("%s" + COACH_FORBIDDEN_FOOD_COMMENT, name);
        System.out.println();
    }

    public static void printResultComment() {
        System.out.println(RESULT_COMMENT);
    }

    public static void printTotalRecommendResult(List<String> categories, CoachRepository coachRepository) {
        StringBuilder sb = new StringBuilder();
        // 첫 줄 만들기
        sb.append(OPEN_PARENTHESIS);
        String firstLine = String.join(MIDDLE_PARENTHESIS, CATEGORIES_WEEK);
        sb.append(firstLine);
        sb.append(CLOSE_PARENTHESIS).append("\n");

        // 두번째 줄 만들기
        sb.append(OPEN_PARENTHESIS);
        sb.append(CATEGORY).append(MIDDLE_PARENTHESIS);
        String secondLine = String.join(MIDDLE_PARENTHESIS, categories);
        sb.append(secondLine);
        sb.append(CLOSE_PARENTHESIS).append("\n");

        // 코치 수 만큼 추천메뉴 만들기
        List<Coach> coaches = coachRepository.getCoaches();
        for(int i=0; i<coaches.size(); i++) {
            Coach coach = coaches.get(i);
            List<String> menus = coach.getRecommendFoods();
            sb.append(OPEN_PARENTHESIS);
            sb.append(coach.getName()).append(MIDDLE_PARENTHESIS);
            String body = String.join(MIDDLE_PARENTHESIS, menus);
            sb.append(body);
            sb.append(CLOSE_PARENTHESIS).append("\n");
        }


        System.out.println(sb);
    }
}
