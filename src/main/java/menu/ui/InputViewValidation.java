package menu.ui;

public class InputViewValidation {

    private final String ERROR = "[ERROR] ";
    private final int MAX_COUCH = 5;
    private final int MIN_COUCH = 2;
    private final int MAX_COUCH_NAME = 5;
    private final int MIN_COUCH_NAME = 2;

    private final String ERROR_COUCH_NUM = "코치는 최소 2명 이상 최대 5명 이하 입력해야 합니다.";
    private final String ERROR_COUCH_NAME_LENGTH = "코치의 이름은 최소 2글자 이상 최대 4글자 이하 입력해야합니다.";

    public void couchNumValidate(String input) {
        String[] couches = input.split(",");

        if (couches.length < MIN_COUCH || couches.length > MAX_COUCH) {
            throw new IllegalArgumentException(ERROR + ERROR_COUCH_NUM);
        }
    }

    public void couchNameValidate(String input) {
        String[] couches = input.split(",");
        for (String couch:
             couches) {
            if (couch.length() < MIN_COUCH_NAME || couch.length() > MAX_COUCH_NAME) {
                throw new IllegalArgumentException(ERROR + ERROR_COUCH_NAME_LENGTH);
            }
        }
    }

}
