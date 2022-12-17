package menu.domain;

public class Validation {

    private static final int MINIMUM_NUMBER = 2;
    private static final int MAXIMUM_NUMBER = 5;
    private static final int MINIMUM_SIZE = 2;
    private static final int MAXIMUM_SIZE = 4;
    private static final int MAXIMUM_MENU = 2;
    private static final String NUMBER_OF_COACHES_ERROR = "[ERROR] 코치는 최소 2명, 최대 5명을 입력해주세요.";
    private static final String NAME_SIZE_ERROR = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자로 입력해주세요.";
    private static final String NUMBER_OF_HATE_MENU_ERROR = "[ERROR] 최소 0개, 최대 2개의 못 먹는 메뉴를 입력해주세요.";

    public void validateNumberOfCoaches(String[] coaches) {
        if (coaches.length < MINIMUM_NUMBER || coaches.length > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OF_COACHES_ERROR);
        }
    }

    public void validateNameSize(String[] coaches) {
        for (String coach: coaches) {
            if (coach.length() < MINIMUM_SIZE || coach.length() > MAXIMUM_SIZE) {
                throw new IllegalArgumentException(NAME_SIZE_ERROR);
            }
        }
    }

    public void validateNumberOfHateMenu(String[] hateMenu) {
        if (hateMenu.length > MAXIMUM_MENU) {
            throw new IllegalArgumentException(NUMBER_OF_HATE_MENU_ERROR);
        }
    }
}