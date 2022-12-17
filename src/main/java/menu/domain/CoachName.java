package menu.domain;

import java.util.regex.Pattern;
import menu.util.NullValidator;

public class CoachName {

    private static final String NOT_RIGHT_FORMAT_MESSAGE = "이름이 올바른 형식이 아닙니다";

    private static final Pattern NAME_RULE = Pattern.compile("^[가-힣]{2,4}$");
    private final String name;

    public CoachName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        NullValidator.throwIfNull(name);
        if (!NAME_RULE.matcher(name).matches()) {
            throw new IllegalArgumentException(NOT_RIGHT_FORMAT_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
