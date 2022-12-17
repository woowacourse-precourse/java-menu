package menu.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FoodCategory {
    JAP(1,"일식"),
    KOR(2,"한식"),
    CHI(3,"중식"),
    ASI(4,"아시안"),
    WES(5,"양식")
    ;

    private final int number;
    private final String label;

    FoodCategory(int number, String label) {
        this.number = number;
        this.label = label;
    }

    public String label() {
        return label;
    }
    public int number() {
        return number;
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
