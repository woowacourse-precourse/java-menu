package menu.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MESSAGE_START = "점심 메뉴 추천을 시작합니다.\n";
    private static final String MESSAGE_RECOMMENDATION = "\n메뉴 추천 결과입니다.";
    private static final String RESULT_DELIMITER = " | ";
    private static final String RESULT_PREFIX = "[ ";
    private static final String RESULT_SUFFIX = " ]";
    private static final String MESSAGE_END = "\n추천을 완료했습니다.";

    public void printStart() {
        System.out.println(MESSAGE_START);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(List<String> daysOfWeek, List<String> recommendCategories,
                            List<List<String>> menusOfCoaches) {
        System.out.println(MESSAGE_RECOMMENDATION);
        System.out.println(standardiseResult(daysOfWeek));
        System.out.println(standardiseResult(recommendCategories));

        for (List<String> menuOfCoach : menusOfCoaches) {
            System.out.println(standardiseResult(menuOfCoach));
        }
    }

    public String standardiseResult(List<String> input) {
        return input.stream().collect(Collectors.joining(RESULT_DELIMITER, RESULT_PREFIX, RESULT_SUFFIX));
    }

    public void printEnd() {
        System.out.println(MESSAGE_END);
    }

}
