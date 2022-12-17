package menu.validator.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCommonValidator {
    public static void validate(String input) {
        validateImpossibleValue(input);
    }
    
    private static void validateImpossibleValue(String input) {
        Matcher matcher = Pattern.compile("[^가-힣,]").matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 한글과 쉼표만 입력할 수 있습니다.");
        }
    }
}
