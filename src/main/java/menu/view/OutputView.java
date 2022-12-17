package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printErrorMessage(String input) {
        System.out.println("[ERROR]" + input);
    }

    public void printList(List<String> inputs) {
        inputs.stream().forEachOrdered(System.out::println);
    }

    public void printRecommendMenu(List<String> inputs) {
        System.out.println(inputs.stream().collect(Collectors.joining(" | ", "[ ", " ]")));
    }

    public void printResult(List<String> inputs) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> forPrint = new ArrayList<>();
        forPrint.add("카테고리");
        forPrint.addAll(inputs);
        System.out.println(forPrint.stream().collect(Collectors.joining(" | ", "[ ", " ]")));
    }

    public void printEndMessage() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    public void printStartMessage() {
        System.out.println();
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }


}
