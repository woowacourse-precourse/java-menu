package menu.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {
    KOR("한식"),
    JAP("일식"),
    CHI("중식"),
    ASI("아시안"),
    WES("양식")
    ;


    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    private static final Map<String, Category> BY_LABEL=
            Stream.of(values()).collect(Collectors.toMap(Category::label, Function.identity()));


    public static Category valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
