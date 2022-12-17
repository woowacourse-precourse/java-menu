package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum InitialMenu {
    JAPANESE(1, "일식", List.of("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼")),
    KOREAN(2, "한식", List.of("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음")),
    CHINESE(3, "중식", List.of("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채")),
    ASIAN(4, "아시안", List.of("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜")),
    AMERICAN(5, "양식", List.of("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));
    private final int number;
    private final String category;
    private final List<String> foods;

    InitialMenu(int number, String category, List<String> foods) {
        this.number = number;
        this.category = category;
        this.foods = foods;
    }

    public int getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getFoods() {
        return foods;
    }

    public static String pickCategory(int number) {
        return checkCategory(number).getCategory();
    }

    private static InitialMenu checkCategory(int number) {
        return Arrays.stream(values())
                .filter(menu -> menu.getNumber() == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 카테고리 번호입니다."));
    }

    //못 먹는 메뉴로 입력한게 여기에 해당하지 않으면 예외
    //
}
