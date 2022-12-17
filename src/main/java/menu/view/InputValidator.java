package menu.view;

import java.util.List;

public class InputValidator {

    private static String INPUT_SIZE_EXCEPTION_MESSAGE_FORMAT = "[ERROR] %d개 이상 %d개 이하의 데이터를 입력해 주세요";

    public void validateInputCount(List<String> input, int minSize, int maxSize) {
        if (input.size() < minSize || input.size() > maxSize) {
            throw new IllegalArgumentException(String.format(INPUT_SIZE_EXCEPTION_MESSAGE_FORMAT, minSize, maxSize));
        }
    }
}
