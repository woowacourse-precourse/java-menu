package menu.di;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.util.NullValidator;

public class ValidateMenuCommand {

    private static final String DELIMITER = ",";
    private static final String NOT_RIGHT_FORMAT_MESSAGE = "형식이 잘못되었습니다";

    private static final Pattern FORMAT = Pattern.compile("[가-힣]+(,[가-힣]+)*");
    private static final String EAT_ALL_MESSAGE = "";

    private final List<String> menus;

    public ValidateMenuCommand(String input) {
        validate(input);
        menus = Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
    }

    private void validate(String input) {
        NullValidator.throwIfNull(input);
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException(NOT_RIGHT_FORMAT_MESSAGE);
        }
    }

    private boolean isRightFormat(String input) {
        if (input.equals(EAT_ALL_MESSAGE)) {
            return true;
        }
        return FORMAT.matcher(input).matches();
    }

    public List<String> getMenus() {
        return menus;
    }
}
