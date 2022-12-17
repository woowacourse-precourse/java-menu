package menu.validator;

import menu.exception.SizeException;

public class NoEatableMenuSizeValidator implements SizeValidator {
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 2;
    private static final String NAME = "코치당 못 먹는 음식들";

    @Override
    public void validate(int size) {
        if (isLessThanMinSize(size) || isGreaterThanMaxSize(size)) {
            throw new SizeException(NAME, MIN_SIZE, MAX_SIZE);
        }
    }

    @Override
    public boolean isLessThanMinSize(int size) {
        return size < MIN_SIZE;
    }

    @Override
    public boolean isGreaterThanMaxSize(int size) {
        return size > MAX_SIZE;
    }
}
