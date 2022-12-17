package menu;

import java.util.List;

public class OutputView {

    public void printResult(List<String> categories,List<String> names, List<List<String>> results) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

    }

}
