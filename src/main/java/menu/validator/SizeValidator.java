package menu.validator;

public interface SizeValidator {
    void validate(int size);

    boolean isLessThanMinSize(int size);

    boolean isGreaterThanMaxSize(int size);
}
