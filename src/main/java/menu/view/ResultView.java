package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String ONE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String END = "추천을 완료했습니다.";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(ONE);
    }

    public static void printCategory(List<String> category) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ 카테고리 | ", " ]");

        category.forEach(stringJoiner::add);

        System.out.println(stringJoiner);
    }

    public static void printAll(List<String> names, List<List<String>> allFoods) {
        List<StringJoiner> stringJoiners = initStringJoiner(names);

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            stringJoiners.get(i).add(name);
            for (int j = 0; j < 5; j++) {
                stringJoiners.get(i).add(allFoods.get(j).get(i));
            }
        }

        stringJoiners.forEach(System.out::println);
        System.out.println();
    }

    private static List<StringJoiner> initStringJoiner(List<String> names) {
        List<StringJoiner> stringJoiners = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            stringJoiners.add(new StringJoiner(" | ", "[ ", " ]"));
        }
        return stringJoiners;
    }

    public static void printEnd() {
        System.out.println(END);
    }
}
