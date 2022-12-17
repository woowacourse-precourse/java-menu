package menu.view;

import menu.dto.RecommendationResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    private OutputView() {}

    public void init() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        printBlankLine();
    }

    public void printRecommendationResult(RecommendationResultDto recommendationResultDto) {
        printResultMessage();
        printCategories(recommendationResultDto.getCategories());
        printResult(recommendationResultDto.getRecommendationResult());
        printBlankLine();
        printFinish();
    }

    private void printResultMessage() {
        System.out.println("메뉴 추천 결과입니다.");
    }

    private void printCategories(List<List<String>> categories) {
        categories.stream()
                .forEach(this::printOneRow);
    }

    private void printResult(List<List<String>> recommendationResult) {
        recommendationResult.stream()
                .forEach(this::printOneRow);
    }

    private void printFinish() {
        System.out.println("추천을 완료했습니다.");
    }

    private void printOneRow(List<String> row) {
        System.out.println(generateRow(row));
    }

    private static String generateRow(List<String> row) {
        return row.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    public void printErr(String message) {
        System.out.println(ERROR_MESSAGE_HEAD + message);
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }
}
