package menu.domain;

import java.util.Arrays;

public enum Style {
    일식(1, "일식"),
    한식(2, "한식"),
    중식(3, "중식"),
    아시안(4, "아시안"),
    양식(5, "양식");

    private static final String INVALID_STYLE_MESSAGE = "[ERROR] 카테고리에 없는 종류입니다.";

    private int code;
    private String value;

    Style(int code, String value) {
        this.code = code;
        this.value = value;
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

    public String getValue() {
        return value;
    }
}
