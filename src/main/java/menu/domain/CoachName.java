package menu.domain;

import java.util.regex.Pattern;

public class CoachName {

    private static final Pattern NAME_RULE = Pattern.compile("^[가-힣]{2,4}$");
    private final String name;

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null 은 이름이 될 수 없습니다");
        }
        if (!NAME_RULE.matcher(name).matches()) {
            throw new IllegalArgumentException("한글 2~4 글자 가 아닙니다");
        }
    }

    public String getName() {
        return name;
    }
}
