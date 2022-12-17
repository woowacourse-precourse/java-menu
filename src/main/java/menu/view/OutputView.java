package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printStartMessage() {
        println("점심 메뉴 추천을 시작합니다.");
        printEnter();
    }

    public void printCoachNamesInputMessage(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printCoachNamesInputMessage() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRecommendedResult(List<Category> categories, List<Coach> coaches) {
        println("메뉴 추천 결과입니다.");
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printRecommendedCategories(categories);
        coaches.forEach(coach -> printRecommendedMenus(coach));
        printEnter();
        println("추천을 완료했습니다.");

    }

    private void printRecommendedCategories(List<Category> categories) {
        StringJoiner joiner = new StringJoiner(" | ","[ "," ]");

        joiner.add("카테고리");
        categories.forEach(category -> joiner.add(category.name()));

        println(joiner.toString());
    }

    private void printRecommendedMenus(Coach coach) {
        StringJoiner joiner = new StringJoiner(" | ","[ "," ]");
        List<Menu> recommendMenus = coach.getRecommendMenus();

        joiner.add(coach.getName());
        recommendMenus.forEach(menu -> joiner.add(menu.name()));

        println(joiner.toString());
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printEnter() {
        System.out.println();
    }

}

