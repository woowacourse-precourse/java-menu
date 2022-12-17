package menu.view;

import menu.domain.People;
import menu.domain.Person;
import menu.domain.Menu;
import menu.dto.output.PrintCriticalExceptionDto;
import menu.dto.output.PrintExceptionDto;
import menu.dto.output.PrintRecommendationsDto;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static final String DELIMITER = " | ";
    public static final String PREFIX = "[ ";
    public static final String SUFFIX = " ]\n";

    private OutputView() {
        System.out.println(ViewMessage.INITIAL_MESSAGE);
    }

    private static class OutputViewSingletonHelper {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewSingletonHelper.OUTPUT_VIEW;
    }

    public void printRecommendations(PrintRecommendationsDto dto) {
        People people = dto.getPeople();
        List<String> shuffledCategory = dto.getShuffledCategory();
        String result = String.format(ViewMessage.RECOMMENDATION_RESULT,
                getCategory(shuffledCategory),
                getRecommendation(people));

        print(result);
    }

    private String getCategory(List<String> shuffledCategory) {
        StringJoiner categoryJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        categoryJoiner.add(ViewMessage.CATEGORY);
        for (String category : shuffledCategory) {
            categoryJoiner.add(category);
        }
        return categoryJoiner.toString();
    }

    private String getRecommendation(People people) {
        StringBuilder result = new StringBuilder();
        for (Person person : people) {
            StringJoiner joiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
            joiner.add(person.getName());
            for (Menu menu : person.getRecommended()) {
                joiner.add(menu.getMenuName());
            }
            result.append(joiner);
        }
        return result.toString();
    }

    public void printException(PrintExceptionDto dto) {
        print(ErrorMessage.ERROR_HEAD + dto.getException().getMessage());
    }

    public void printCriticalException(PrintCriticalExceptionDto dto) {
        print(ErrorMessage.UNEXPECTED_ERROR,
                ErrorMessage.ERROR_HEAD + dto.getException().getMessage());
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void print(String... messages) {
        for (String message : messages) {
            print(message);
        }
    }

    private static final class ErrorMessage {
        private static final String ERROR_HEAD = "[ERROR] ";
        private static final String UNEXPECTED_ERROR = "예기치 못한 오류가 발생했습니다.";
    }

    private static final class ViewMessage {
        private static final String INITIAL_MESSAGE = "점심 메뉴 추천을 시작합니다.";
        public static final String CATEGORY = "카테고리";
        private static final String RECOMMENDATION_RESULT = "\n메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "%s" +
                "%s\n" +
                "\n추천을 완료했습니다.";
    }
}
