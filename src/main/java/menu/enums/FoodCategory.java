package menu.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FoodCategory {
    KOR("한식"),
    JAP("일식"),
    CHI("중식"),
    ASI("아시안"),
    WES("양식")
    ;

    private final String label;

    FoodCategory(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    private static final Map<String, FoodCategory> BY_LABEL=
            Stream.of(values()).collect(Collectors.toMap(FoodCategory::label, Function.identity()));


    public static FoodCategory valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
