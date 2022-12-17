package menu.domain;

import java.util.regex.Pattern;

public class CoachName {

    private static final Pattern NAME_CONVENTION = Pattern.compile("^[가-힣]{2,4}$");
    private final String name;

    public CoachName(final String name) {
        validateCoachName(name);
        this.name = name;
    }

    private void validateCoachName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("null 은 이름이 될 수 없습니다");
        }
        if (!NAME_CONVENTION.matcher(name).matches()) {
            throw new IllegalArgumentException("한글 2~4 글자 가 아닙니다");
        }
    }

    public String getName() {
        return name;
    }
}