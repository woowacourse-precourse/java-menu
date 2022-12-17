package menu.exception;

import menu.utils.Converter;

import java.util.List;

public class NoMenuException extends CommonException{
    private final Converter converter;

    public NoMenuException(Converter converter) {
        this.converter = converter;
    }

    @Override
    public void verifyException(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkSeperatedByComma(input, 0, 1);

        List<String> noMenus = converter.convertToList(input);
        checkNoMenuCount(noMenus);
    }

    private void checkNoMenuCount(List<String> noMenus) {
        if (noMenus.size() > 2) {
            throw new IllegalArgumentException(ExceptionCode.OUT_OF_RANGE_NO_MENU_COUNT.getMessage());
        }
    }
}
