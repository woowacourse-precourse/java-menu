package menu.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RECOMMENDATION_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.\n" +
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
            "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]";
    private static final String BLANK_SPACE = " ";
    private static final String RECOMMENDATION_HEAD = "[";
    private static final String RECOMMENDATION_TAIL = "]";
    private static final String PARTITION = "|";
    private static final String FINISHED_MESSAGE = "\n추천을 완료했습니다.";
    

    private static final String EXCEPTION_MESSAGE = "[ERROR] ";

    public void printRecommendationStart() {
        System.out.println(RECOMMENDATION_START_MESSAGE);
    }

    public void printResults(Map<String, List<String>> results) {
        System.out.println(RESULT_MESSAGE);
        for (Map.Entry<String, List<String>> result : results.entrySet()) {
            final StringJoiner resultFormat = new StringJoiner(BLANK_SPACE);
            updateFormat(resultFormat, result.getKey(), result.getValue());
            System.out.println(resultFormat);
        }
        System.out.println(FINISHED_MESSAGE);
    }

    private void updateFormat(StringJoiner resultFormat, String crewName, List<String> recommendedFoods) {
        resultFormat.add(RECOMMENDATION_HEAD);
        resultFormat.add(crewName);
        resultFormat.add(PARTITION);
        addMenu(resultFormat, recommendedFoods);
        resultFormat.add(RECOMMENDATION_TAIL);
    }

    private void addMenu(StringJoiner resultFormat, List<String> recommendedFoods) {
        IntStream.range(0, recommendedFoods.size()).forEach(index -> {
            resultFormat.add(recommendedFoods.get(index));
            addPartition(index, recommendedFoods, resultFormat);
        });
    }

    private void addPartition(int index, List<String> result, StringJoiner resultFormat) {
        if (hasMoreThanTwoElements(result) && isNotLastIndex(index, result)) {
            resultFormat.add(PARTITION);
        }
    }

    private boolean hasMoreThanTwoElements(List<String> result) {
        return result.size() >= 2;
    }

    private boolean isNotLastIndex(int index, List<String> result) {
        return index != result.size() - 1;
    }


    public void printErrorMessage(String message) {
        System.out.println(EXCEPTION_MESSAGE + message);
    }
}
