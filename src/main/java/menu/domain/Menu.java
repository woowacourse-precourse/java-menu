package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.domain.Category.*;
import static menu.util.Constants.ERROR_PREFIX;

public enum Menu {
    KO_1(KOREAN, "김밥"), KO_2(KOREAN, "김치찌개"), KO_3(KOREAN, "쌈밥"), KO_4(KOREAN, "된장찌개"), KO_5(KOREAN, "비빔밥"), KO_6(KOREAN, "칼국수"), KO_7(KOREAN, "불고기"), KO_8(KOREAN, "떡볶이"), KO_9(KOREAN, "제육볶음"),
    JP_1(JAPANESE, "규동"), JP_2(JAPANESE, "우동"), JP_3(JAPANESE, "미소시루"), JP_4(JAPANESE, "스시"), JP_5(JAPANESE, "가츠동"), JP_6(JAPANESE, "오니기리"), JP_7(JAPANESE, "하이라이스"), JP_8(JAPANESE, "라멘"), JP_9(JAPANESE, "오코노미야끼"),
    CH_1(CHINESE, "깐풍기"), CH_2(CHINESE, "볶음면"), CH_3(CHINESE, "동파육"), CH_4(CHINESE, "짜장면"), CH_5(CHINESE, "짬뽕"), CH_6(CHINESE, "마파두부"), CH_7(CHINESE, "탕수육"), CH_8(CHINESE, "토마토 달걀볶음"), CH_9(CHINESE, "고추잡채"),
    AS_1(ASIAN, "팟타이"), AS_2(ASIAN, "카오 팟"), AS_3(ASIAN, "나시고렝"), AS_4(ASIAN, "파인애플 볶음밥"), AS_5(ASIAN, "쌀국수"), AS_6(ASIAN, "똠얌꿈"), AS_7(ASIAN, "반미"), AS_8(ASIAN, "월남쌈"), AS_9(ASIAN, "분짜"),
    WE_1(WESTERN, "라자냐"), WE_2(WESTERN, "그라탱"), WE_3(WESTERN, "뇨끼"), WE_4(WESTERN, "끼슈"), WE_5(WESTERN, "프렌치 토스트"), WE_6(WESTERN, "바게트"), WE_7(WESTERN, "스파게티"), WE_8(WESTERN, "피자"), WE_9(WESTERN, "파니니");

    private Category category;
    private String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu checkIsMenuExist(String inputMenuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(inputMenuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 메뉴입니다."));
    }

    public static List<Menu> getAllMenuOfCategory(Category category) {
        return Arrays.stream(values())
                .filter(menu -> menu.category == category)
                .collect(Collectors.toList());
    }
}
