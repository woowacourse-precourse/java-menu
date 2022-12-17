package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASCKET("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DISTRIBUTION("배포");

    private String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public static List<Missions> getMissionsList() {
//        return Arrays.stream(Missions.values())
//                .collect(Collectors.toList());
//    }
//
//    public static List<String> getMissionsValueList() {
//        return Arrays.stream(Missions.values())
//                .map(Missions::getName)
//                .collect(Collectors.toList());
//    }
//
//    public static Missions getEnum(String input) {
//        return Arrays.stream(Missions.values())
//                .filter(value -> value.name.equals(input))
//                .findAny()
//                .orElse(null);
//    }
}
