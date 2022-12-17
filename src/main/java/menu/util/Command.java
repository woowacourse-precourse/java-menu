package menu.util;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum Command {
    HATE_MENU(2)
    , COACH_NAME_LENGTH_MIN(2)
    , COACH_NAME_LENGTH_MAX(4)
    , NUMBER_OF_COACH_MIN(2)
    , NUMBER_OF_COACH_MAX(5)
    ;

    private final int data;

    Command(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

}
