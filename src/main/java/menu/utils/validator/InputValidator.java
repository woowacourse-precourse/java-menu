package menu.utils.validator;

public interface InputValidator {
    String DELIMITER = ",";
    char DELIMITER_CHAR = ',';

    void validate(String input);
}
