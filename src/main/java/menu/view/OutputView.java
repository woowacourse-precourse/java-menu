package menu.view;

import menu.domain.People;
import menu.domain.Person;
import menu.domain.menu.Menu;
import menu.dto.output.PrintCriticalExceptionDto;
import menu.dto.output.PrintExceptionDto;
import menu.dto.output.PrintRecommendationsDto;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String errorHead = "[ERROR] ";

    private OutputView() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
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

        StringBuilder result = new StringBuilder("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n");
        result.append(getCategory(shuffledCategory));
        result.append(getRecommendation(people));
        System.out.println(result);
    }

    private String getRecommendation(People people) {
        StringBuilder result = new StringBuilder();

        for (Person person : people) {
            StringJoiner joiner = new StringJoiner(" | ", "[ ", "]\n");
            joiner.add(person.getName());
            for (Menu menu : person.getRecommended()) {
                joiner.add(menu.getMenuName());
            }
            result.append(joiner);
        }
        return result.toString();
    }

    private String  getCategory(List<String> shuffledCategory) {
        StringJoiner categoryJoiner = new StringJoiner(" | ", "[ ", "]\n");
        categoryJoiner.add("카테고리");
        for (String category : shuffledCategory) {
            categoryJoiner.add(category);
        }
        return categoryJoiner.toString();
    }

    public void printException(PrintExceptionDto dto) {
        System.out.println(errorHead + dto.getException().getMessage());
    }

    public void printCriticalException(PrintCriticalExceptionDto dto) {
        System.out.println("예기치 못한 오류가 발생했습니다.");
        System.out.println(errorHead + dto.getException().getMessage());
    }
}
