package menu.view;

import java.util.List;
import menu.dto.RecommendationResultDto;

public class OutputView {
    private final String START = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_INFO = "메뉴 추천 결과입니다.";
    private final String DAY = "구분";
    private final String CATEGORY = "카테고리";
    private final String START_DELIMITER = "[ ";
    private final String END_DELIMITER = " ]";
    private final String DELIMITER = " | ";
    private final String END = "추천을 완료했습니다.";

    public OutputView() {
    }

    public void printStart() {
        System.out.println(START);
    }

    public void printResult(List<String> days, List<String> categories) {
        System.out.println(RESULT_INFO);
        System.out.println(transferToList(DAY, days));
        System.out.println(transferToList(CATEGORY, categories));
    }

    public void printRecommendation(List<RecommendationResultDto> result) {
        result.stream()
                .forEach(data -> System.out.println(transferToList(data.getCoach(), data.getFoods())));
        System.out.println(END);
    }

    private String transferToList(String division, List<String> content) {
        StringBuilder builder = new StringBuilder(START_DELIMITER);
        builder.append(division)
                .append(DELIMITER)
                .append(String.join(DELIMITER, content))
                .append(END_DELIMITER);
        return builder.toString();

    }
}
