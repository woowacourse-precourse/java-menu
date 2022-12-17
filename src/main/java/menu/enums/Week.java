package menu.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Week {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일")
    ;

    private final String label;

    Week(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    private static final Map<String, Week> BY_LABEL=
            Stream.of(values()).collect(Collectors.toMap(Week::label, Function.identity()));


    public static Week valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
