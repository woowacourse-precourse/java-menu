package menu.di;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.util.NullValidator;

public class ValidateNameCommand {

    private static final String NOT_RIGHT_FORMAT_MESSAGE = "형식이 잘못되었습니다";
    private static final Pattern FORMAT = Pattern.compile("[가-힣]+(,[가-힣]+)*");

    private final List<String> names;

    public ValidateNameCommand(String input) {
        validate(input);
        names = Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private void validate(String input) {
        NullValidator.throwIfNull(input);
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException(NOT_RIGHT_FORMAT_MESSAGE);
        }
    }

    private boolean isRightFormat(String input) {
        return FORMAT.matcher(input).matches();
    }

    public List<String> getNames() {
        return names;
    }
}
