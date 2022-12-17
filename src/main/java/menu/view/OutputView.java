package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.DTO.RecommedResultDTO;

public class OutputView {

    private static final String RESULT_HEADLINE = "메뉴 추천 결과입니다.";
    private static final String RESULT_COLUMN_HEADLINE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "카테고리";
    private static final String LEFT_SIDE_BAR = "[ ";
    private static final String RIGHT_SIDE_BAR = " ]";
    private static final String DELIMITER = " | ";

    public static void printResult(RecommedResultDTO recommedResultDTO) {
        List<String> category = recommedResultDTO.getCategories();
        List<List<String>> result = recommedResultDTO.getResult();
        System.out.println(RESULT_HEADLINE);
        System.out.println(RESULT_COLUMN_HEADLINE);
        System.out.println(LEFT_SIDE_BAR + CATEGORY +
                String.join(DELIMITER, category) + RIGHT_SIDE_BAR);
        result.forEach(coach -> System.out.println(LEFT_SIDE_BAR +
                String.join(DELIMITER, coach) + RIGHT_SIDE_BAR));
    }
}
