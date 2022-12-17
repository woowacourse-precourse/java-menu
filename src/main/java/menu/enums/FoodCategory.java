package menu.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FoodCategory {
    JAP(1,"일식","규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOR(2,"한식","김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHI(3,"중식","깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASI(4,"아시안","팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WES(5,"양식","라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니")
    ;

    private final int number;
    private final String label;
    private final String menus;

    FoodCategory(int number, String label, String menus) {
        this.number = number;
        this.label = label;
        this.menus = menus;
    }

    public String label() {
        return label;
    }
    public int number() {
        return number;
    }
    public String menus() {
        return menus;
    }

    private static final Map<String, FoodCategory> BY_LABEL=
            Stream.of(values()).collect(Collectors.toMap(FoodCategory::label, Function.identity()));

    private static final Map<Integer, FoodCategory> BY_NUMBER=
            Stream.of(values()).collect(Collectors.toMap(FoodCategory::number, Function.identity()));

    public static FoodCategory valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static FoodCategory valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }

}
