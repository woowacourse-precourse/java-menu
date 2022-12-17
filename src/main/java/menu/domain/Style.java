package menu.domain;

import java.util.Arrays;

public enum Style {
    일식(1),
    한식(2),
    중식(3),
    아시안(4),
    양식(5);

    private int code;
    private static final String INVALID_STYLE_MESSAGE = "[ERROR] 카테고리에 없는 종류입니다.";
    Style(int code) {
        this.code = code;
    }

    public static Style get(int style) {
        return Arrays.stream(Style.values())
                .filter(s -> s.code == style)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_STYLE_MESSAGE));
    }

    public int getCode() {
        return code;
    }
}
