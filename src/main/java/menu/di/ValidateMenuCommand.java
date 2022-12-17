package menu.di;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidateMenuCommand {

    private static final Pattern FORMAT = Pattern.compile("[가-힣]+(,[가-힣]+)*");

    private final List<String> menus;

    public ValidateMenuCommand(String input) {
        validate(input);
        menus = Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 은 입력받을 수 없습니다");
        }
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException("형식이 잘못되었습니다");
        }
    }

    private boolean isRightFormat(String input) {
        if (input.equals("")) {
            return true;
        }
        return FORMAT.matcher(input).matches();
    }

    public List<String> getMenus() {
        return menus;
    }
}
